package webdev.models;

import java.util.ArrayList;

public class MultipleChoiceExamQuestion extends BaseExamQuestion {
	private ArrayList<String> choices;
	private int selectedChoice;
	
	public ArrayList<String> getChoices() {
		return choices;
	}
	
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
	public int getSelectedChoice() {
		return selectedChoice;
	}
	public void setSelectedChoice(int selectedChoice) {
		this.selectedChoice = selectedChoice;
	}
}
