package raisetech.studentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.studentManagement.data.StudentCourse;

@Mapper

public interface StudentCourseRepository {

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> search();

}
