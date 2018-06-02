package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import webdev.models.Course;
import webdev.models.Lesson;
import webdev.repositories.CourseRepository;
import webdev.repositories.LessonRepository;
import webdev.repositories.ModuleRepository;

import java.util.*;
import javax.servlet.http.HttpSession;

@RestController
public class LessonService {
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("api/course/{cid}/module/{mid}/lesson")
	public Lesson createLesson(@PathVariable("cid") int cid,
			@PathVariable("mid") int mid, 
			@RequestBody Lesson lesson) {
		return null;
	}
	
	@GetMapping("/api/lesson")
	public List<Lesson> findAllLessons() {
		return (List<Lesson>) lessonRepository.findAll();
	}
	
	@GetMapping("/api/lesson/{id}")
	public Lesson findLessonById(@PathVariable("id") int id) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(id);
		if (maybeLesson.isPresent()) {
			return maybeLesson.get();
		}
		return null;
	}
	
	@PutMapping("/api/lesson/{id}")
	public void updateLesson(@PathVariable("id") int id,
			@RequestBody Lesson newLesson) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(id);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			lesson.set(newLesson);
			lessonRepository.save(lesson);
		}
	}

}
