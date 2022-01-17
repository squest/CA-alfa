(ns user
  (:require [clj-arangodb.arangodb.core :as a]
            [clj-arangodb.arangodb.databases :as d]
            [clj-arangodb.arangodb.collections :as c]
            [clj-arangodb.arangodb.adapter :as adapter])
  (:import [com.arangodb Protocol]
           [com.arangodb.entity BaseDocument]
           [com.arangodb.velocypack VPackSlice]))

(defonce conn (atom {}))

(def default-config
  {:useProtocol Protocol/VST
   :user        "zenius"
   :password    "mizone"
   :host        ["127.0.0.1" 8529]})

(def do-config
  {:useProtocol Protocol/VST
   :user        "root"
   :host        ["128.199.252.210" 8528]})

(def local-do-config
  {:useProtocol Protocol/VST
   :user        "root"
   :host        ["127.0.0.1" 8528]})

(defn connect!
  ([config]
   (reset! conn (a/connect config)))
  ([] (connect! default-config)))

(defn disconnect! []
  (swap! conn a/shutdown))






