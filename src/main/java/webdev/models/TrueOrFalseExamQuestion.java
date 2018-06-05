package webdev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLE_TRUE_OR_FALSE_QUESTION")
public class TrueOrFalseExamQuestion extends BaseExamQuestion {
	@Column(name = "IS_TRUE")
	private boolean isTrue;

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}
