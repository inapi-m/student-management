package raisetech.studentmanagement.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentCourse;
import raisetech.studentmanagement.domain.StudentDetail;
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

  @Transactional
  public void registerStudent(StudentDetail studentDetail) {
    studentRepository.registerStudent(studentDetail.getStudent());
    
    List<StudentCourse> studentCourses = studentDetail.getStudentCourses();
    if (studentCourses == null) {
      return;
    }

    for(StudentCourse studentCourse : studentCourses) {
      studentCourse.setStudentId(studentDetail.getStudent().getStudentId());
      
      if (studentCourse.getStartDate() == null) {
        studentCourse.setStartDate(LocalDate.now());
      }
      if (studentCourse.getExpectedEndDate() == null) {
        studentCourse.setExpectedEndDate(LocalDate.now().plusYears(1));
      }
      
      studentCourseRepository.registerStudentCourse(studentCourse);
    }
  }
}

