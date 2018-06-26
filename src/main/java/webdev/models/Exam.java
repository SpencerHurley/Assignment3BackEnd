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
public class Exam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JsonIgnore
	private Lesson lesson;
	
	@OneToMany(mappedBy="exam")
	private List<BaseExamQuestion> questions;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public List<BaseExamQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<BaseExamQuestion> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(BaseExamQuestion q) {
		this.questions.add(q);
	}
}