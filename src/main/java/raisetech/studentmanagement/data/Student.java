package raisetech.studentmanagement.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String studentId;
  private String fullName;
  private String furigana;
  private String nickname;
  private String email;
  private String city;
  private String gender;
  private int age;
  private String remark;
  private boolean isDelated;


}

