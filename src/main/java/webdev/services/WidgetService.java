package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webdev.models.Lesson;
import webdev.models.User;
import webdev.models.Widget;
import webdev.repositories.WidgetRepository;
import webdev.repositories.LessonRepository;

import java.util.*;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("/api/widget")	
	public List<Widget> findAllWidgets() {
		return (List<Widget>) widgetRepository.findAll();
	}
	
	@PostMapping("/api/lesson/{lessonId}/widget")
	public Widget createUser(@RequestBody Widget widget, @PathVariable("lessonId") int id) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(id);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			lesson.addWidget(widget);
		}
		return widget;
	}
	
	@GetMapping("/api/widget/{wid}")
	public Widget getWidgetById(@PathVariable("wid") int wid) {
		Optional<Widget> maybeWidget = widgetRepository.findById(wid);
		if (maybeWidget.isPresent()) {
			return maybeWidget.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/api/lesson/{lessonId}/widget")
	public List<Widget> getWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(lessonId);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			return lesson.getWidgets();
		} else {
			return new ArrayList<Widget>();
		}
	}
	
	@PutMapping("/api/widget/{widgetId}")
	public Widget updateWidget(@PathVariable("widgetId") int id, @RequestBody Widget w) {
		Optional<Widget> maybeWidget = widgetRepository.findById(id);
		if (maybeWidget.isPresent()) {
			Widget toUpdate = maybeWidget.get();
			toUpdate.set(w);
			widgetRepository.save(toUpdate);
		}
		return null;
	}
	
	@DeleteMapping("/api/widget/:widgetId")
	public void deleteUser(@PathVariable("widgetId") int id) {
		widgetRepository.deleteById(id);
	}
}
