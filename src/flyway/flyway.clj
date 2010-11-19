(ns flyway.flyway
  (:import [javax.sql DataSource])
  (:import [org.apache.commons.dbcp BasicDataSource])
  (:import [com.googlecode.flyway.core Flyway])
  (:import [com.googlecode.flyway.core.validation ValidationMode ValidationErrorMode]))

(defn- data-source [project]
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


    