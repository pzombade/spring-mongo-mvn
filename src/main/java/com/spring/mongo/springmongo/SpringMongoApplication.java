package com.spring.mongo.springmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoApplication {

//	@Autowired
//	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(){
//		return  new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("Inserting an emp");
//				employeeRepository.save(new Employee(111L,"Pz"));
//			}
//		};
//	}

}
