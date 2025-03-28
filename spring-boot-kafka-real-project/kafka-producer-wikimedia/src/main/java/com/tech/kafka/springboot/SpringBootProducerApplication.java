package com.tech.kafka.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
	private final WikimediaChangesProducer wikimediaChangesProducer;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class);
	}

	public SpringBootProducerApplication(WikimediaChangesProducer wikimediaChangesProducer) {
		this.wikimediaChangesProducer = wikimediaChangesProducer;
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.sendMessage();
	}
}
