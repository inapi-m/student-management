
package raisetech.studentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.studentManagement.data.Students;

/**
 * 受講生情報を扱うリポジトリ
 * 全件検索や単一条件での検索、コース情報の検索が行えるクラス
 */
@Mapper
public interface StudentRepository {


  @Select("SELECT * FROM students")
  List<Students> search();
}

