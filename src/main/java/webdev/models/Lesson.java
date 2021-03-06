package webdev.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  @ManyToOne
  private Module module;
  
  @OneToMany(mappedBy="lesson")
  @JsonIgnore
  private List<Exam> exams;
  
  public List<Exam> getExams() {
	return exams;
  }
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

@OneToMany(mappedBy="lesson")
  private List<Widget> widgets;
  	
  public int getId() {
	  return this.id;
  }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	public void set(Lesson l) {
		this.setTitle(l.getTitle());
		this.setModule(l.getModule());
	}
	
	public List<Widget> getWidgets() {
		return this.widgets;
	}
	
	public void addWidget(Widget w) {
		this.widgets.add(w);
	}
	
	public void addExam(Exam e) {
		this.exams.add(e);
	}
}
