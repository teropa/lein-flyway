(ns leiningen.flyway-init
  (:use flyway.flyway)
  (:import [com.googlecode.flyway.core.migration SchemaVersion]))

(defn flyway-init [project & [initial-version initial-description]]
  "Creates and initializes the Flyway metadata table.
   Parameters: initial-version (optional) - The initial version to put in the
               metadata table. Only migrations with a version number higher than
               this one will be considered for this database. The default is 0.
               initial-description (optional) - The description of the initial version."
  (let [f (flyway project)]
    (if initial-version
        (.init f (SchemaVersion. initial-version) initial-description)
        (.init f nil initial-description))))
