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
  @JsonIgnore
  private Module module;
  
  @OneToMany(mappedBy="lesson")
  private List<Assignment> assignments;
  
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
	
	public List<Assignment> getAssignments() {
		return this.assignments;
	}
	
	public void addAssignment(Assignment a) {
		this.assignments.add(a);
	}
}
