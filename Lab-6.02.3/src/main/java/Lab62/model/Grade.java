package Lab62.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private Integer id;
    private String studentId;
    private Double grade;
}
