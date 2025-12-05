package raisetech.studentmanagement.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String studentId;
  @NotBlank
  private String fullName;
  private String furigana;
  private String nickname;
  @NotBlank
  private String email;
  private String city;
  private String gender;
  private int age;
  private String remark;
  private boolean isDeleted;


}

