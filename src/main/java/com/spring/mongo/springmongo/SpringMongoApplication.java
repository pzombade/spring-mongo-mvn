package com.spring.mongo.springmongo;

import com.spring.mongo.springmongo.models.Employee;
import com.spring.mongo.springmongo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMongoApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
		System.out.println("Hello");
	}

	@Bean
	public CommandLineRunner init(){
		return  new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("Inserting an emp");
				employeeRepository.save(new Employee(111L,"Pz"));
			}
		};
	}

}
