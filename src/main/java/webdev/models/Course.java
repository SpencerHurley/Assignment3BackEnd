package webdev.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified;
  @OneToMany(mappedBy="course")
  private List<Module> modules;
}
