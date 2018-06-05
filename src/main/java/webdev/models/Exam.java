package webdev.models;

import java.util.List;

public class Exam {
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
