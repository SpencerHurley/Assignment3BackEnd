package webdev.repositories;

import webdev.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository <Course, Integer> {

}
