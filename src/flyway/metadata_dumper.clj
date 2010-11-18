(ns flyway.metadata-dumper
  (:import [java.text SimpleDateFormat])
  (:import [com.googlecode.flyway.core.util StringUtils]))

(defn- format-date [date]
  (.format (SimpleDateFormat. "yyyy-MM-dd HH:mm:ss") date))

(defn dump [rows]
  (println "+-------------+------------------------+---------------------+---------+")
  (println "| Version     | Description            | Installed on        | State   |")
  (println "+-------------+------------------------+---------------------+---------+")
  (if (seq rows)
    (doseq [row rows]
      (println "|" (StringUtils/trimOrPad (.. row getVersion toString) 11)
               "|" (StringUtils/trimOrPad (.getDescription row) 22)
               "|" (StringUtils/trimOrPad (format-date (.getInstalledOn row)) 19)
               "|" (StringUtils/trimOrPad (.. row getState name) 7)
               "|"))
    (println "| No migrations applied yet"))
  (println "+-------------+------------------------+---------------------+---------+"))

  
