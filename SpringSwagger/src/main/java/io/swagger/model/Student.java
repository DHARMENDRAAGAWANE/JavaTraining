package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Course;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-31T06:06:48.387Z")

public class Student   {
  @JsonProperty("studentId")
  private Long studentId = null;

  @JsonProperty("studentName")
  private String studentName = null;

  @JsonProperty("age")
  private Long age = null;

  @JsonProperty("dateOfBirth")
  private OffsetDateTime dateOfBirth = null;

  /**
   * gender
   */
  public enum GenderEnum {
    MALE("male"),
    
    FEMALE("female");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenderEnum fromValue(String text) {
      for (GenderEnum b : GenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender = null;

  @JsonProperty("course")
  private Course course = null;

  public Student studentId(Long studentId) {
    this.studentId = studentId;
    return this;
  }

  /**
   * Get studentId
   * @return studentId
  **/
  @ApiModelProperty(value = "")


  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Student studentName(String studentName) {
    this.studentName = studentName;
    return this;
  }

  /**
   * Get studentName
   * @return studentName
  **/
  @ApiModelProperty(value = "")


  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public Student age(Long age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")


  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public Student dateOfBirth(OffsetDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(OffsetDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Student gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * gender
   * @return gender
  **/
  @ApiModelProperty(value = "gender")


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public Student course(Course course) {
    this.course = course;
    return this;
  }

  /**
   * Get course
   * @return course
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.studentId, student.studentId) &&
        Objects.equals(this.studentName, student.studentName) &&
        Objects.equals(this.age, student.age) &&
        Objects.equals(this.dateOfBirth, student.dateOfBirth) &&
        Objects.equals(this.gender, student.gender) &&
        Objects.equals(this.course, student.course);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentId, studentName, age, dateOfBirth, gender, course);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    
    sb.append("    studentId: ").append(toIndentedString(studentId)).append("\n");
    sb.append("    studentName: ").append(toIndentedString(studentName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    course: ").append(toIndentedString(course)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

