package webdev.models;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;	
  private String phone;
  private String email;
  private String role;
  private Date dateOfBirth;
  
  public User(int id, String username, String firstName, String lastName,
		  String phone, String email, String role, Date dateofBirth) {
	  this.id = id;
	  this.username = username;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.phone = phone;
	  this.email = email;
	  this.role = role;
	  this.dateOfBirth = dateOfBirth;
  }
  
  public int getId() {
    return id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
	return password;
  }
  public void setPassword(String password) {
	this.password = password;  
  }
  public String getFirstName() {
		return firstName;
  }
  public void setFirstName(String firstName) {
	  this.firstName = firstName;
  }
  public String getLastName() {
		return lastName;
  }
  public void setLastName(String lastName) {
		 this.lastName = lastName;
  }
  public String getPhone() {
		return phone;
  }
  public void setPhone(String phone) {
		this.phone = phone;
  }
  public String getEmail() {
		return email;
  }
  public void setEmail(String email) {
		this.email = email;
  }
  public String getRole() {
	  return role;
  }
  public void setRole(String role) {
	  this.role = role;
  }
  public Date getDate() {
	  return dateOfBirth;
  }
  public void setDate(Date date) {
	  this.dateOfBirth = date;
  }
  
  public void set(User user) {
	  this.setDate(user.getDate());
	  this.setEmail(user.getEmail());
	  this.setFirstName(user.getFirstName());
	  this.setLastName(user.getLastName());
	  this.setPassword(user.getPassword());
	  this.setPhone(user.getPhone());
	  this.setRole(user.getRole());
	  this.setUsername(user.getUsername());
  }
}
