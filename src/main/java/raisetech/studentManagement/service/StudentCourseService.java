package raisetech.studentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.studentManagement.data.StudentCourse;
import raisetech.studentManagement.repository.StudentCourseRepository;

@Service
public class StudentCourseService {

  private StudentCourseRepository studentCourseRepository;

  @Autowired
  public StudentCourseService(StudentCourseRepository studentCourseRepository) {
    this.studentCourseRepository = studentCourseRepository;
  }

  public List<StudentCourse> searchStudentCourseList() {

    //絞り込み検索でJava基礎コースのコース情報のみを抽出
    //抽出したリストをコントローラーに返す
    return studentCourseRepository.search().stream()
        .filter(StudentCourse -> StudentCourse.getCourseName().equals("Java基礎コース"))
        .collect(Collectors.toList());

  }

}
