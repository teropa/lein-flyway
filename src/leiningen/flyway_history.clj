(ns leiningen.flyway-history
  (:use flyway.flyway flyway.metadata-dumper))

(defn flyway-history [project]
  "Returns the history (all applied migrations) of the database."
  (-> (flyway project) .history dump))
