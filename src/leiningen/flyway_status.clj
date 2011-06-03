(ns leiningen.flyway-status
  (:use flyway.flyway flyway.metadata-dumper))

(defn flyway-status [project]
  "Returns the status (current version) of the database."
  (if-let [status (.status (flyway project))]
    (dump [status])
    (println "Flyway not initialized yet")))
