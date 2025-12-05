package raisetech.studentmanagement.repository;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.studentmanagement.data.Student;

@Mapper
public interface StudentRepository {


  @Select("SELECT * FROM students Where is_deleted = false")
  List<Student> search();

  @Select("SELECT * FROM students WHERE student_id = #{studentId} AND is_deleted = false")
  Student searchStudent(String studentId);

  @Insert("INSERT INTO students (full_name, furigana, nickname, email, city, age, gender, remark, is_deleted) "
      + "VALUES (#{fullName}, #{furigana}, #{nickname}, #{email}, #{city}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "studentId")
  void registerStudent(Student student);
}

