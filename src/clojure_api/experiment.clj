(ns clojure-api.experiment
  (:use clojure.pprint))


; como chamar um metodo com dois paramentros
; como passar uma funcao como parametro de callback
; como passar uma funcao lambda como parametro de callback
;(defn executa [record callback]
;  (println "enviando message: " record)
;  (callback 2))
;
;(executa "important" #(* %1 3))


; Como utilizar o main em clojure
;(defn -main [& args]
;  (println "Executando...."))


; como agrupar mapas para gerar relatorios (count, sum, avg)
(def lives [{:start "2022-01-01" :level "BEGINNER" :slots 15 :bookings 10 :presences 5}
            {:start "2022-01-02" :level "BEGINNER" :slots 15 :bookings 10 :presences 5}
            {:start "2022-01-02" :level "BEGINNER" :slots 15 :bookings 10 :presences 5}
            {:start "2022-01-03" :level "INTERMEDIATE" :slots 15 :bookings 10 :presences 5}
            {:start "2022-01-03" :level "INTERMEDIATE" :slots 15 :bookings 10 :presences 5}
            {:start "2022-01-03" :level "INTERMEDIATE" :slots 15 :bookings 10 :presences 5}])

; quantidade de aulas por dia
(def aulas-por-dia (group-by :start lives))
;(pprint (class aulas-por-dia))
;(pprint aulas-por-dia)
(defn opa [[key value]] ; desestrutura um mapa
  (pprint key)
  ;(pprint (class value))
  (pprint (count value)))

(defn report [[key value]]
  {:date key
   :qty (count value)
   })

;(pprint (map opa aulas-por-dia))
(pprint (map report aulas-por-dia))

; quantidade de aulas por nivel


; Como ler um arquivo json e deserializar os valores em um mapa

