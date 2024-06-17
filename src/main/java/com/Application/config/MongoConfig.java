package com.Application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClients;

@Configuration
@ComponentScan(basePackages="com.Application")
@EnableMongoRepositories(basePackages="com.Application.repository")
public class MongoConfig {
	@Bean
	public SimpleMongoClientDatabaseFactory factory() {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create("mongodb://localhost:27017"), "Aravind");
	}
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(factory());
	}

}