Il Dockerfile è composto da due layer, il primo utilizza maven per la build copiando dalla cartella corrente il pom e la cartella src dentro al container.
Il secondo layer utilizza la jre 11 per la copia del jar buildato nell'immagine precedente e successivamente per l'avvio del producer (demo.jar).

I comandi usati per buildare e runnare sono in ordine:

docker build ./ --tag kafka_java_prod

docker run -it --network tap kafka_java_prod:latest --name kafka_producer1
