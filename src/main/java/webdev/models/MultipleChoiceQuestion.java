package webdev.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class MultipleChoiceQuestion extends BaseExamQuestion {
	private ArrayList<String> choices;
	
	public ArrayList<String> getChoices() {
		return choices;
	}
	
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
}