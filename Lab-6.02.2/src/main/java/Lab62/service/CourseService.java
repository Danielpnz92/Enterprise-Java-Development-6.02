package Lab62.service;

import Lab62.Repository.CourseRepository;
import Lab62.Repository.GradeRepository;
import Lab62.dto.CourseGrade;
import Lab62.model.Course;
import Lab62.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeRepository gradeRepository;


    public CourseGrade getCourseGrade(int courseId) {
        Optional<Course> co =  courseRepository.findById(courseId);
        if(co.isPresent()){
            List<Grade> courseGrades = co.get().getGrades();
            return new CourseGrade(courseId,courseGrades);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found");
        }
    }

    public void addGradeToCourse(Integer gradeId, Integer courseId) {
        Course course = courseRepository.findById(courseId).get();

        Grade rating = gradeRepository.findById(gradeId).get();
        course.getGrades().add(rating);
        courseRepository.save(course);
    }
}
