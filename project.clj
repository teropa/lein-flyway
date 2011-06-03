(defproject lein-flyway "1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [com.googlecode.flyway/flyway-core "1.4"]
                 [commons-dbcp "1.4"]
                 [org.springframework/spring-jdbc "2.5.6"]
                 [postgresql "9.0-801.jdbc4"]]
  :eval-in-leiningen true
  :flyway {:driver "org.postgresql.Driver" :url "jdbc:postgresql:flyway" :username "postgres" :password ""})

