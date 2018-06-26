package webdev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class FillInTheBlanksQuestion extends BaseExamQuestion {
	private String formattedText;
	public String getFormattedText() {
		return formattedText;
	}

	public void setFormattedText(String formattedText) {
		this.formattedText = formattedText;
	}

}