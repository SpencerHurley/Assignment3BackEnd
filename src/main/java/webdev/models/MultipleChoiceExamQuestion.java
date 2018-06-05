package webdev.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLE_MULTIPLE_CHOICE_QUESTION")
public class MultipleChoiceExamQuestion extends BaseExamQuestion {
	@Column(name="CHOICES")
	private ArrayList<String> choices;
	
	public ArrayList<String> getChoices() {
		return choices;
	}
	
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
}
