package raisetech.studentmanagement.data;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourse {

  private String courseId;
  private String studentId;
  @NotBlank
  private String courseName;
  private LocalDate startDate;
  private LocalDate expectedEndDate;


}
