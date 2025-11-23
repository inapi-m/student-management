package raisetech.studentmanagement.controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentCourse;
import raisetech.studentmanagement.domain.StudentDetail;
@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourse> studentCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    //取得した学生リスト（students）を１件ずつ取り出して処理する
    //最終的な成果物となるStudentDetailクラスのインスタンスを生成し、学生の基本情報をセットする
    // 現在の学生が受講しているコース情報を格納するリストを作成
    // 全受講コースリストをループし、現在の学生IDと一致するものを抽出する
    // フィルタリングして集めた「この学生の受講コースリスト」を、詳細情報オブジェクトにセット
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);
      List<StudentCourse> convertStudentCourses = studentCourses.stream()
          .filter(studentCourse -> student.getStudentId().equals(studentCourse.getStudentId()))
          .collect(Collectors.toList());
      studentDetail.setStudentCourses(convertStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;

  }
}
