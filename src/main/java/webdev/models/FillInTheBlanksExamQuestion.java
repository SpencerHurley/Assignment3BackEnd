package webdev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLE_FILL_IN_THE_BLANK_QUESTION")
public class FillInTheBlanksExamQuestion extends BaseExamQuestion {
	@Column(name = "VARIABLES")
	private String formattedText;

	public String getFormattedText() {
		return formattedText;
	}

	public void setFormattedText(String formattedText) {
		this.formattedText = formattedText;
	}

}
