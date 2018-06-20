
package webdev.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String name;
  private String text;
  private String className;
  private String style;
  private String width;
  private String height;
  private Integer size;
  private String href;
  private String src;
  private String listItems;
  private String widgetType;
  
  @ManyToOne
  @JsonIgnore
  private Lesson lesson;
  
  public int getId() {
	return id;
}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getWidth() {
		return width;
	}
	
	public void setWidth(String width) {
		this.width = width;
	}
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public String getSrc() {
		return src;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getListItems() {
		return listItems;
	}
	
	public void setListItems(String listItems) {
		this.listItems = listItems;
	}
	
	public Lesson getLesson() {
		return lesson;
	}
	
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	public String getWidgetType() {
		return this.widgetType;
	}
	
	public void setWidgetType(String s) {
		this.widgetType = s;
	}
	  
	public void set(Widget o) {
		this.name = o.name;
		this.text = o.text;
		this.className = o.className;
		this.style = o.style;
		this.width = o.width;
		this.height = o.height;
		this.size = o.size;
		this.href = o.href;
		this.src = o.src;
		this.listItems = o.listItems;
	}
}