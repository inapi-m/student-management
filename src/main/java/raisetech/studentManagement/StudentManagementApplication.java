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

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studentManagement.data.StudentCourse;
import raisetech.studentManagement.data.Students;
import raisetech.studentManagement.repository.StudentCourseRepository;
import raisetech.studentManagement.repository.StudentRepository;

@SpringBootApplication
@RestController
@MapperScan("raisetech.studentManagement") // ← MyBatisのMapper自動スキャン

public class StudentManagementApplication {


  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }



}




