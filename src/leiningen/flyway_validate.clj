(ns leiningen.flyway-validate
  (:use flyway.flyway))

(defn flyway-validate [project]
  (-> (flyway project) .validate))
