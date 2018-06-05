package webdev.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@OneToMany(mappedBy="Exam")
	private List<BaseExamQuestion> questions;

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
