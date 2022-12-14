package Lab62.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseName;

    //relación manytomany ya que habrá varias evaluaciones por curso, y dicha evaluación puede repetirse
    //para el mismo estudiante en diferentes cursos
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_grades",
            joinColumns = { @JoinColumn(name = "course_id")},
            inverseJoinColumns = { @JoinColumn(name = "grade_id")}
    )
    private List<Grade> grades;
}
