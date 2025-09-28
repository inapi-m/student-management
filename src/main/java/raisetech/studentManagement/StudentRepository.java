/*package raisetech.studentManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM student WHERE name = #{name}")
  Student searchByName(@Param("name") String name);

}*/
package raisetech.studentManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentRepository {

  @Select("SELECT name, age FROM student LIMIT 1")
  Student selectAny();

  @Select("SELECT name, age FROM student WHERE name = #{name}")
  Student searchByName(@Param("name") String name);

  @Insert("INSERT student values(#{name},#{age})")
  void registerStudent(String name, int age);

  @Update("UPDATE student SET age = #{age} WHERE name =#{name} ")
  void updateStudent(String name, int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);
}
