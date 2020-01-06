package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return args -> {
			Account account = new Account();
			account.setUsername("doik");
			mongoTemplate.insert(account);

			Account account2 = new Account();
			account2.setUsername("simon");
			accountRepository.insert(account2);
		};
	}

}
