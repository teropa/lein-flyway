(ns leiningen.flyway-status
  (:use flyway.flyway flyway.metadata-dumper))

(defn flyway-status [project]
  (if-let [status (.status (flyway project))]
    (dump [status])
    (println "Flyway not initialized yet")))
