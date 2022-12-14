package Lab62.dto;

import Lab62.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseGrade {

    private Integer courseId;
    private List<Grade> grades;
}
