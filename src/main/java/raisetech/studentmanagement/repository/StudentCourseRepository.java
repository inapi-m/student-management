package raisetech.studentmanagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.studentmanagement.data.StudentCourse;

@Mapper

public interface StudentCourseRepository {

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> search();

  @Insert("INSERT INTO students_courses (student_id, course_name, start_date, expected_end_date) "
      + "VALUES (#{studentId}, #{courseName}, #{startDate}, #{expectedEndDate})")
  @Options(useGeneratedKeys = true, keyProperty = "courseId")
  void registerStudentCourse(StudentCourse studentCourse);
}
