package Lab62.controller;

import Lab62.Repository.CourseRepository;
import Lab62.dto.CourseGrade;
import Lab62.model.Course;
import Lab62.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public CourseService courseService;

    @GetMapping("/course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseInfo(@PathVariable Integer courseId){
        return courseRepository.findById(courseId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @GetMapping("/course/{courseId}/grades")
    @ResponseStatus(HttpStatus.OK)
    public CourseGrade getCourseGrades(@PathVariable int courseId) {
        return courseService.getCourseGrade(courseId);
    }
}
