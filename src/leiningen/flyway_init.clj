(ns leiningen.flyway-init
  (:use flyway.flyway)
  (:import [com.googlecode.flyway.core.migration SchemaVersion]))

(defn flyway-init [project & [initial-version initial-description]]
  (let [f (flyway project)]
    (if initial-version
        (.init f (SchemaVersion. initial-version) initial-description)
        (.init f nil initial-description))))
