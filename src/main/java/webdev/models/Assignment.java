package webdev.models;

public class Assignment {
	private int id;
	private String description;
	private String title;
	private int points;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void set(Assignment that) {
		this.setDescription(that.getDescription());
		this.setPoints(that.getPoints());
		this.setTitle(that.getTitle());
	}
}
