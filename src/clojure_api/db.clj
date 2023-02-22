(ns clojure-api.db
  (:use clojure.pprint)
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/ecommerce")

(defn abre-conexao []
  (d/create-database db-uri)
  (d/connect db-uri))

(defn apaga-banco []
  (d/delete-database db-uri))

; transacionar o schema para criar no banco
; para adicionar dados tem que transacionar a estrutura de dados

(def meu-schema [{
                  :db/ident :produto/nome
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "O nome de um produto"
                   }])

(defn cria-schema [conn]
  (d/transact conn meu-schema))

