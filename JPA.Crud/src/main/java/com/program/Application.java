package com.program;



import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		  ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
	      UserRepository repository = context.getBean(UserRepository.class);   
	School s=new School();
	s.setId(102);
	s.setName("kuchbhi Khan");
	s.setAddress("Rampur");
	
	School s1=new School();
	s1.setId(103);
	s1.setName("salman Abdul Gani");
	s1.setAddress("bhatpara");
	
	School s2=new School();
	s2.setId(104);
	s2.setName("Salman");
	s2.setAddress("Khalilabad");
	
	List<School> list = List.of(s,s1,s2);
	Iterable<School> itr = repository.saveAll(list);
System.out.println(itr);
	System.out.println("data is inserted......");
	
	//single data fatch 
	Optional<School> findById = repository.findById(101);
	System.out.println(findById);
	
	//multiple data fatching
	/*Iterable<School> findAll = repository.findAll();
	for(School i:findAll) {
		System.out.println(i);
		*/
	
	
		//deleting single data
		/*
		 * repository.deleteById(103); 
		 * System.out.println("data is deleted.....");
		 */
	
	
	//updating data 
	Optional<School> findById2 = repository.findById(101);
	School school = findById2.get();
	school.setName("Khan");
	School save = repository.save(school);
	System.out.println(save);
	System.out.println("data is updated..args..");
	}
	}


