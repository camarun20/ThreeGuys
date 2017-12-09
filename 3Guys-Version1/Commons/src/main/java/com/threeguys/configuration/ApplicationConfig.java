package com.threeguys.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages = "com.threeguys")
public class ApplicationConfig {
	
	
   @Value("${spring.data.mongodb.host}")
   private String hostName;

   @Value("${spring.data.mongodb.database}")
   private String dbName;

   @Value("${spring.data.mongodb.port}")
   private int dbPort;

	
//   spring.data.mongodb.host=127.0.0.1
//   spring.data.mongodb.port=27017
//   spring.data.mongodb.database=threeguys
//	
   
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		
		System.out.println(" ------- DB  Initiatization ");
		System.out.println(" Port " +dbPort);
		System.out.println(" hostName " +hostName);
		System.out.println(" dbName " +dbName);
		System.out.println(" dbPort " +dbPort);
		
	        MongoClient mongoClient = new MongoClient(hostName, dbPort);	       
	        return new SimpleMongoDbFactory(mongoClient, dbName );
	 }
	 
	 @Bean
	 public MongoTemplate mongoTemplate() throws Exception {
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
	        return mongoTemplate;
	   }

}
