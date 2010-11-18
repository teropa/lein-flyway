(ns leiningen.flyway-migrate
  (:use flyway.flyway))

(defn flyway-migrate [project]
  (-> (flyway project)
      (.migrate)))
