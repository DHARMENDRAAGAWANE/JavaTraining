package com.mt.daretotry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mt.daretotry.entity.User;
import com.mt.daretotry.entity.UserType;
import com.mt.daretotry.repository.UserRepository;


@SpringBootApplication
public class DareToTryApplication implements CommandLineRunner {

	
	@Autowired
	UserRepository userReposiotry;
	public static void main(String[] args) {
		SpringApplication.run(DareToTryApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {

		/*userReposiotry.deleteAll();

		// save a couple of customers
		userReposiotry.save(new User("Alice", "Smith",UserType.User));
		userReposiotry.save(new User("Bob", "Smith",UserType.User));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (User customer : userReposiotry.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(userReposiotry.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for ( User customer: userReposiotry.findByLastName("Smith")) {
			System.out.println(customer);
		}*/
		

	}
	
}
