(ns leiningen.flyway-migrate
  (:use flyway.flyway))

(defn flyway-migrate [project]
  "Starts the database migration. All pending migrations will be applied in order."
  (-> (flyway project)
      (.migrate)))
