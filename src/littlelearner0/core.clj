(ns littlelearner0.core
  (:require [littlelearner0.ch03])
  (:gen-class))

(require '[nextjournal.clerk :as clerk])

;; start Clerk's built-in webserver on the default port 7777, opening the browser when done
(clerk/serve! {:browse false
               :watch-paths ["src/littlelearner0"]})

;; either call `clerk/show!` explicitly
;; (clerk/show! "notebooks/rule_30.clj")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "done elhamdulillah."))
