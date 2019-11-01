package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Course
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-31T06:06:48.387Z")

public class Course   {
  @JsonProperty("courseId")
  private Long courseId = null;

  @JsonProperty("courseName")
  private String courseName = null;

  @JsonProperty("courseMajor")
  private String courseMajor = null;

  @JsonProperty("duration")
  private Long duration = null;

  public Course courseId(Long courseId) {
    this.courseId = courseId;
    return this;
  }

  /**
   * Get courseId
   * @return courseId
  **/
  @ApiModelProperty(value = "")


  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public Course courseName(String courseName) {
    this.courseName = courseName;
    return this;
  }

  /**
   * Get courseName
   * @return courseName
  **/
  @ApiModelProperty(value = "")


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Course courseMajor(String courseMajor) {
    this.courseMajor = courseMajor;
    return this;
  }

  /**
   * Get courseMajor
   * @return courseMajor
  **/
  @ApiModelProperty(value = "")


  public String getCourseMajor() {
    return courseMajor;
  }

  public void setCourseMajor(String courseMajor) {
    this.courseMajor = courseMajor;
  }

  public Course duration(Long duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
  **/
  @ApiModelProperty(value = "")


  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(this.courseId, course.courseId) &&
        Objects.equals(this.courseName, course.courseName) &&
        Objects.equals(this.courseMajor, course.courseMajor) &&
        Objects.equals(this.duration, course.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseId, courseName, courseMajor, duration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Course {\n");
    
    sb.append("    courseId: ").append(toIndentedString(courseId)).append("\n");
    sb.append("    courseName: ").append(toIndentedString(courseName)).append("\n");
    sb.append("    courseMajor: ").append(toIndentedString(courseMajor)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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

