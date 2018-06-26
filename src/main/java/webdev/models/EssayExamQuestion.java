package webdev.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class EssayExamQuestion extends BaseExamQuestion {
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}