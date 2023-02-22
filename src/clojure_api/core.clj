(ns clojure-api.core
  (:use clojure.pprint)
  (:import java.util.Date java.time.LocalDateTime)
  (:require
    [datomic.api :as d]
    [clojure-api.model :as model]
    [clojure-api.db :as db]
    [clojure-api.broker :as kafka]))

;(def conn (db/abre-conexao))
;(db/cria-schema conn)
;(let [p1 (model/produto "Computador Um")]
;  (d/transact conn [p1]) )

; https://clojure-doc.org/articles/language/interop/
;(println (LocalDateTime/now))



