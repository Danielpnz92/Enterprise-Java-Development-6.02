package Lab62;

import Lab62.Repository.StudentRepository;
import Lab62.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(StudentRepository studentRepository) {
		return args -> {

			studentRepository.save(new Student("s1", "grsgsr", 23));
			studentRepository.save(new Student("s2", "jghyjgj", 19));
			studentRepository.save(new Student("s3", "yutrhf", 20));
			studentRepository.save(new Student("s4", "vchgdfh", 21));
		};
	}

}
