package raisetech.studentManagement.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studentManagement.data.StudentCourse;
import raisetech.studentManagement.service.StudentCourseService;

@RestController
public class StudentCourseController {

  private StudentCourseService studentCourseService;

  @Autowired
  public StudentCourseController(StudentCourseService studentCourseService) {
    this.studentCourseService = studentCourseService;
  }

  @GetMapping("/studentCourseList")
  public List<StudentCourse> getStudentCourseList() {
    return studentCourseService.searchStudentCourseList();
  }

}
