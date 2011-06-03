(ns leiningen.flyway-clean
  (:use flyway.flyway))

(defn flyway-clean [project]
  "Drops all objects (tables, views, procedures, triggers, ...) in the configured schemas."
  (-> (flyway project) .clean))
