(ns flyway.flyway
  (:import [javax.sql DataSource])
  (:import [org.apache.commons.dbcp BasicDataSource])
  (:import [com.googlecode.flyway.core Flyway])
  (:import [com.googlecode.flyway.core.validation ValidationMode ValidationErrorMode]))

(defn- data-source [project]
  "Creates and initializes an object of the org.apache.commons.dbcp.BasicDataSource class.
   It uses the values of the :driver, :url, :username and :password keys of the map
   passed to the project argument."
  (let [conf (project :flyway)]
    (doto (BasicDataSource.)
      (.setDriverClassName (:driver conf))
      (.setUrl (:url conf))
      (.setUsername (:username conf))
      (.setPassword (or (:password conf) "")))))

(defn- configure [project & args]
  (doseq [[k setter] (partition 2 args)]
    (if-let [prop (get-in project [:flyway k])]
      (setter prop))))

(defn flyway [project]
  "Initializes and returns an object of the com.googlecode.flyway.core.Flyway class.
   It sets the various properties of this object like setTable, setBaseDir, setEncoding,
   setSqlMigrationPrefix, setSqlMigrationSuffix, setValidationMode and setValidationErrorMode
   using the :table, :base-dir, :encoding, :sql-migration-prefix, :sql-migration-suffix,
   :validation-mode and :validation-error-mode keys respectively of the map passed to
   the project argument."
  (let [f (Flyway.)]
    (.setDataSource f (data-source project))
    (configure project
      :table #(.setTable f %)
      :base-dir #(.setBaseDir f %)
      :encoding #(.setEncoding f %)
      :sql-migration-prefix #(.setSqlMigrationPrefix f %)
      :sql-migration-suffix #(.setSqlMigrationSuffix f %)
      :validation-mode #(.setValidationMode f (ValidationMode/valueOf (.toUpperCase %)))
      :validation-error-mode #(.setValidationErrorMode f (ValidationErrorMode/valueOf (.toUpperCase %))))
    f))


    