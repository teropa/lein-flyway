(ns leiningen.flyway-history
  (:use flyway.flyway flyway.metadata-dumper))

(defn flyway-history [project]
  (-> (flyway project) .history dump))
