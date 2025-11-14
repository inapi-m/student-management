package raisetech.studentmanagement.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService studentService;


  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }


  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return studentService.searchStudentList();
  }


}
