Docker-compose che avvia i seguenti container: Zookeeper, Broker Kafka, Topic-creator, Kafka-UI e Logstash.
Basta utilizzare il comando: 

docker compose up

Vi è inoltre un semplice form html di test per l'invio di richieste a logstash che a sua volta le invia sottoforma di json al topic kafka.




Attenzione,
problema con riavvio del broker: zookeeper non rileva subito la chiusura del vecchio
broker e quindi non permette di avviare il nuovo, dando errore di nodo già esistente
Per il resto funziona tutto al primo avvio, per i successivi avvii, aspettare il
caricamento corretto di zookeeper e poi startare il broker.

Aggiornamento: attraverso un healtcheck su zookeeper il problema sopra citato è stato risolto.

