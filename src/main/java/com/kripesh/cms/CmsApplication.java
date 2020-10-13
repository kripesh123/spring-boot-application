package com.kripesh.cms;

import com.kripesh.cms.dao.StudentRepository;
import com.kripesh.cms.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CmsApplication {

	@Autowired
	private Environment env;

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
			log.info("{}", env.getProperty("JAVA_HOME"));
			log.info("{}", env.getProperty("MAVEN_HOME"));
			log.info("{}", env.getProperty("app.name"));
			repository.save(new Student("Sagun","Gurung","sagun@gamail.com"));
			repository.save(new Student("Kripesh","Bista","kripesh@gamail.com"));
			repository.save(new Student("Ram","Gurung","ram@gamail.com"));
			repository.save(new Student("Shyam","Dhakal","shyam@gamail.com"));
			repository.save(new Student("Krishna","Dahal","Krishna@gamail.com"));

			List<Student> students = repository.findByNameEndsWith("am");
			log.info(String.valueOf(students));
		};
	}





}
