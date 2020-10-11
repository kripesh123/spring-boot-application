package com.kripesh.cms;

import com.kripesh.cms.dao.StudentRepository;
import com.kripesh.cms.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CmsApplication {

	private static final Logger log = LoggerFactory.getLogger(CmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			// save a few students
			repository.save(new Student("Sagun","Gurung","sagun@gamail.com"));
			repository.save(new Student("Kripesh","Bista","sagun@gamail.com"));
			repository.save(new Student("Ram","Gurung","sagun@gamail.com"));
			repository.save(new Student("Shyam","Dhakal","sagun@gamail.com"));
			repository.save(new Student("Krishna","Dahal","sagun@gamail.com"));

			// get all student
			log.info("Student findALl()");
			for (Student s: repository.findAll()) {
				log.info(s.toString());
			}
			log.info(" ");

			// get student by id
			Student s  = repository.findById(1l);
			log.info(s.toString());
			log.info(" ");


			// get student by last name
			repository.findByLastName("Gurung").forEach(student -> log.info(student.toString()));

//			log.info("Lets see Beans:");
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for(String beanName : beanNames) {
//				log.info(beanName);
//			}
		};
	}





}
