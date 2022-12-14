package Lab62;

import Lab62.Repository.CourseRepository;
import Lab62.Repository.GradeRepository;
import Lab62.model.Course;
import Lab62.model.Grade;
import Lab62.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class GradeCourseServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(GradeCourseServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CourseRepository courseRepository, GradeRepository gradeRepository, CourseService courseService) {
		return args -> {

			courseRepository.save(new Course(null, "maths", new ArrayList<>()));
			gradeRepository.save(new Grade(null,"s1",8.0));
			gradeRepository.save(new Grade(null,"s2",7.0));

			courseService.addGradeToCourse(1, 1);
			courseService.addGradeToCourse(2,1);
		};
	}

}
