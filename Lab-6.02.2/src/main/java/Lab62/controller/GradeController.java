package Lab62.controller;

import Lab62.Repository.GradeRepository;
import Lab62.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class GradeController {

    @Autowired
    public GradeRepository gradeRepository;

    @GetMapping("/grade/{gradeId}")
    @ResponseStatus(HttpStatus.OK)
    public Grade getGradetInfo(@PathVariable Integer gradeId){
        return gradeRepository.findById(gradeId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Grade not found"));
    }
}
