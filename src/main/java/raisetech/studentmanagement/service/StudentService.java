package raisetech.studentmanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentCourse;
import raisetech.studentmanagement.repository.StudentCourseRepository;
import raisetech.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository studentRepository;
  private StudentCourseRepository studentCourseRepository;

  public StudentService(StudentRepository studentRepository,
      StudentCourseRepository studentCourseRepository) {
    this.studentRepository = studentRepository;
    this.studentCourseRepository = studentCourseRepository;
  }

  public List<Student> searchStudentList() {

    return studentRepository.search();


  }

  public List<StudentCourse> searchStudentCourseList() {
    return studentCourseRepository.search();
  }
}

