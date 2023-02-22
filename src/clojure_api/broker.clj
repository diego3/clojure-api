(ns clojure-api.broker
  (:use clojure.pprint)
  (:import org.apache.kafka.clients.producer.ProducerConfig
           (org.apache.kafka.clients.producer KafkaProducer ProducerRecord Callback)
           (org.apache.kafka.common.serialization StringSerializer))
  )


;https://github.com/FundingCircle/jackdaw/tree/master/examples

(defn create-record [message]
  "record topic key value"
  (ProducerRecord. "NEW_ORDER" message))

(defn create-producer []
  (KafkaProducer. {ProducerConfig/BOOTSTRAP_SERVERS_CONFIG      "127.0.0.1:9092"
                   ProducerConfig/KEY_SERIALIZER_CLASS_CONFIG   StringSerializer
                   ProducerConfig/VALUE_SERIALIZER_CLASS_CONFIG StringSerializer}))
(defn send-message [message]
  (.send (create-producer) (create-record message)))

(def mycallback
  (reify Callback
    (onCompletion [this metadata e]
      (println "partition" (.partition metadata))
      (println "topic" (.topic metadata))
      (println "offset" (.offset metadata)))))

(defn send2 [message]
  (.send (create-producer) (create-record message) mycallback))

;(send2 "3115151151511")
;(let [f @(send-message "9999, 1544.88, 998888")]
;
;  )


