(ns leiningen.flyway-clean
  (:use flyway.flyway))

(defn flyway-clean [project]
  (-> (flyway project) .clean))
