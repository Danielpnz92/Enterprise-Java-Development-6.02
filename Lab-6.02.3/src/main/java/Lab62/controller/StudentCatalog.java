package Lab62.controller;

import Lab62.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentCatalog {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalogs/course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable String courseId) {

        Course course = restTemplate.getForObject("http://grades-data-service/api/course/" + courseId, Course.class);
        CourseGrade courseGrades = restTemplate.getForObject("http://grades-data-service/api/course/" + courseId + "/grades", CourseGrade.class);

        Catalog catalog = new Catalog();
        catalog.setCourseName(course.getCourseName());
        List<StudentGrade> studentGradeList = new ArrayList<>();

        //Loop over all user ratings and get the movie information for each rating
        for(Grade grade: courseGrades.getGrades()){
            Student student = restTemplate.getForObject("http://student-info-service/api/students/" + grade.getStudentId(), Student.class);
            studentGradeList.add(new StudentGrade(student.getName(), student.getAge(), grade.getGrade()));
        }

        catalog.setStudentGradeList(studentGradeList);
        return catalog;
    }
}
