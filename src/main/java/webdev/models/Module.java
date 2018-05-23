package webdev.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Module {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  @ManyToOne
  @JsonIgnore
  private Course course;
  
  public String getTitle() {
	  return this.title;
  }
  public void setTitle(String title) {
	  this.title = title;
  }
  
  public Course getCourse() {
	  return this.course;
  }
  public void setCourse(Course course) {
	  this.course = course;
  }
}
