package com.tap.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.*;
import java.util.Properties;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);



		String bootstrapServers = "10.0.100.1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


		
		producerMessage(producerCreate(properties));

	}


	public static KafkaProducer producerCreate(Properties properties){
		 // create the producer
		 KafkaProducer<String, String> producer =null;
		 try{
		 	producer = new KafkaProducer<>(properties);
		 }catch(Exception e){e.printStackTrace();return null;}
		 
		 return producer;
	}

	public static void producerMessage(KafkaProducer producer){
			 // create a producer record
			 int z=0;
			 while(z<1000){
				ProducerRecord<String, String> producerRecord = new ProducerRecord<>("tap", "messaggio prodotto numero "+z);
				try{
					Thread.sleep(1000);
				}catch(Exception e){e.printStackTrace();}
				z++;
				

				 // send data - asynchronous
				 producer.send(producerRecord);

				 // flush data - synchronous
				 producer.flush();
				 
				 // flush and close producer
				 //producer.close();
			 }
	}

}
