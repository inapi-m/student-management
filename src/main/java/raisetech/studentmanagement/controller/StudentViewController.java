package raisetech.studentmanagement.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentCourse;
import raisetech.studentmanagement.domain.StudentDetail;
import raisetech.studentmanagement.service.StudentService;
import org.springframework.ui.Model;


@Controller
public class StudentViewController {

  private final StudentService service;

  public StudentViewController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/students")
  public String showStudentList(Model model) {

    // DB から一覧取得
    List<Student> studentList = service.searchStudentList();

    // HTML に渡す
    model.addAttribute("studentList", studentList);

    // resources/templates/studentList.html を表示
    return "studentList";

  }

  // 登録画面を表示する用（新規追加）
  @GetMapping("/newStudent")
  public String showStudentForm(Model model) {
    // フォームバインディング用の空のオブジェクトを用意
    StudentDetail studentDetail = new StudentDetail();
    //空のオブジェクトに対しインスタンスをセットし初期化
    studentDetail.setStudent(new Student());
    studentDetail.setStudentCourses(Arrays.asList(new StudentCourse())); // 少なくとも1つのコース入力欄を表示する
    //ここでは中身を初期化したstudentDetailを渡している
    model.addAttribute("studentDetail", studentDetail);
    return "registerStudent";
  }

  // 登録処理を受け取る用
  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute @Validated StudentDetail studentDetail,
      BindingResult result) {
    // studentDetail.getStudent() や studentDetail.getStudentCourses() でデータを取り出して登録処理を行う


    if (result.hasErrors()) {
      // エラー内容をコンソールに出力して確認する
      result.getAllErrors().forEach(error -> System.out.println(error.toString()));
      return "registerStudent";
    }
    service.registerStudent(studentDetail);
    return "redirect:/students";
  }
}
