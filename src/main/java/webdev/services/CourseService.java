package webdev.services;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import webdev.models.Course;
import webdev.models.Module;
import webdev.repositories.CourseRepository;

import java.util.*;
import javax.servlet.http.HttpSession;

@RestController
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/course")
	public Course createCourse(
			@RequestBody Course newCourse) {
		return courseRepository.save(newCourse);
	}
	
	@DeleteMapping("/api/course/{id}")
	public void deleteCourse(@PathVariable("id") int id) {
		courseRepository.deleteById(id);
	}
	
	@GetMapping("/api/course")
	public List<Course> findAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}
	
	@GetMapping("/api/course/{id}")
	public Course findCourseById(@PathVariable("id") int id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		}
		return null;
	}
	
	@PutMapping("/api/course/{id}")
	public void updateCourse(@PathVariable("id") int id,
			@RequestBody Course newCourse) {
		Optional<Course> maybeCourse = courseRepository.findById(id);
		if (maybeCourse.isPresent()) {
			Course course = maybeCourse.get();
			course.setCreated(newCourse.getCreated());
			course.setModified(newCourse.getModified());
			course.setModules(newCourse.getModules());
			course.setTitle(newCourse.getTitle());
			courseRepository.save(course);
		}
	}
}
