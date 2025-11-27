package raisetech.studentmanagement.domain;

import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentCourse;

@Getter
@Setter
public class StudentDetail {
  @Valid
  private Student student;

  @Valid
  private List<StudentCourse> studentCourses;
}


