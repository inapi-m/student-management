package raisetech.studentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studentManagement.data.Students;
import raisetech.studentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }



  @Autowired

  @GetMapping("/studentList")
  public List<Students> getStudentList() {
    return studentService.serchStudentList();
  }


}
