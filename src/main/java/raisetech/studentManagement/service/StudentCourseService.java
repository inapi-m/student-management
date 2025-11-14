package raisetech.studentManagement.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import raisetech.studentManagement.data.StudentCourse;
import raisetech.studentManagement.repository.StudentCourseRepository;

@Service
public class StudentCourseService {

  private StudentCourseRepository studentCourseRepository;


  public StudentCourseService(StudentCourseRepository studentCourseRepository) {
    this.studentCourseRepository = studentCourseRepository;
  }

  public List<StudentCourse> searchStudentCourseList() {

    //絞り込み検索でJava基礎コースのコース情報のみを抽出
    //抽出したリストをコントローラーに返す
    return studentCourseRepository.search().stream()
        .filter(studentCourse -> Objects.equals(studentCourse.getCourseName(),"Java基礎コース"))
        .collect(Collectors.toList());

  }

}
