package raisetech.studentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.studentManagement.data.StudentCourse;
import raisetech.studentManagement.data.Students;
import raisetech.studentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.studentRepository = repository;
  }

  public List<Students> serchStudentList() {
    //検索処理
    return studentRepository.search().stream()
        .filter(students -> students.getAge() >= 23)
        .collect(Collectors.toList());
    //絞り込みをする。年齢が23以上の人のみを抽出する
    //抽出したリストをコントローラーに返す


  }




}
