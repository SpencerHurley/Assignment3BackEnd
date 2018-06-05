package webdev.services;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import webdev.models.Assignment;
import webdev.models.Course;
import webdev.models.Lesson;
import webdev.models.Module;
import webdev.repositories.AssignmentRepository;
import webdev.repositories.LessonRepository;

import java.util.*;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AssignmentService {
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	@PostMapping("/api/lesson/{lid}/assignment")
	public Assignment createAssignment(@RequestBody Assignment newAssignment,
			@PathVariable("lid") int lid) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(lid);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			lesson.addAssignment(newAssignment);
		}
		return null;
	}
	
	@DeleteMapping("/api/assignment/{aid}")
	public void deleteAssignment(@PathVariable("aid") int aid) {
		assignmentRepository.deleteById(aid);
	}
	
	@GetMapping("/api/assignment")
	public List<Assignment> findAllCourses() {
		return (List<Assignment>) assignmentRepository.findAll();
	}
	
	@GetMapping("/api/course/{id}")
	public Assignment findAssignmentById(@PathVariable("id") int id) {
		Optional<Assignment> assignment = assignmentRepository.findById(id);
		if (assignment.isPresent()) {
			return assignment.get();
		}
		return null;
	}
	
	public List<Assignment> findAssignmentsForLesson(@PathVariable("lid") int lid) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(lid);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			return lesson.getAssignments();
		}
		return null;
	}
}
