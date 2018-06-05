package webdev.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLE_ESSAY_QUESTION")
public class EssayExamQuestion extends BaseExamQuestion {
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
