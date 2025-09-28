/*package raisetech.studentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

  @Autowired
  private StudentRepository repository;

  private String name = "Mizuki Inazuka";
  private String age = "37";

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}


  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    Student student = repository.searchByName("KOUJI");

    return student.getName() + " " + student.getAge() +"歳";

  }
@PostMapping("/studentInfo")
  public void setStudentInfo(String name, String age){
    this.name = name;
    this.age = age;

}

@PostMapping
  public void updateStudentName(String name){
    this.name = name;
}
}*/

package raisetech.studentManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("raisetech.studentManagement") // ← MyBatisのMapper自動スキャン

public class StudentManagementApplication {

  @Autowired
  private StudentRepository repository;// ★ ここでリポジトリを注入

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }

  // 起動確認用（DBもRepositoryも使わない）
  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  // DB確認用
  @GetMapping("/testAny")
  public String testAny() {
    try {
      Student s = repository.selectAny();
      if (s == null)
        return "not found";
      return s.getName() + " " + s.getAge();
    } catch (Exception e) {
      e.printStackTrace();
      Throwable c = (e.getCause() != null) ? e.getCause() : e;
      return "ERROR(testAny): " + c.getClass().getSimpleName() + " - " + c.getMessage();
    }
  }

  @GetMapping("/student")
  public String getStudent(@RequestParam("name")String name) {
    Student s = repository.searchByName(name);
    if (s == null) {
      return "not found";
    } else {
      return s.getName() + " " + s.getAge() + "歳";
    }

  }

  @PostMapping("/student")
  public void registerStudent(String name, int age) {
    repository.registerStudent(name, age);

  }

  @PatchMapping("/student")
  public void updateStudent(String name, int age){
    repository.updateStudent(name, age);
  }

  @DeleteMapping("/student")
  public void deleteStudent(String name){
    repository.deleteStudent(name);
  }
}

