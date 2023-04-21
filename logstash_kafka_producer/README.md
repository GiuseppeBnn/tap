Docker-compose che avvia i seguenti container: Zookeeper, Broker Kafka, Topic-creator, Kafka-UI e Logstash.
Basta utilizzare il comando: 

docker-compose up




Attenzione,
problema con riavvio del broker: zookeeper non rileva subito la chiusura del vecchio
broker e quindi non permette di avviare il nuovo, dando errore di nodo già esistente
Per il resto funziona tutto al primo avvio, per i successivi avvii, aspettare il
caricamento corretto di zookeeper e poi startare il broker.