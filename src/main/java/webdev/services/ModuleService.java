package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import webdev.models.Course;
import webdev.models.Module;
import webdev.repositories.CourseRepository;
import webdev.repositories.ModuleRepository;

import java.util.*;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*")
public class ModuleService {
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/course/{cid}/module")
	public Module createModule(
			@PathVariable("cid") int cid,
			@RequestBody Module newModule) {
		Optional<Course> data = courseRepository.findById(cid);
		if(data.isPresent()) {
			Course course = data.get();
			newModule.setCourse(course);
			return moduleRepository.save(newModule);
		}
		return null;
	}
	
	@DeleteMapping("/api/module/{id}")
	public void deleteModule(@PathVariable("id") int id) {
		moduleRepository.deleteById(id);
	}
	
	@GetMapping("/api/module")
	public List<Module> findAllModules() {
		return (List <Module>) moduleRepository.findAll();
	}
	
	@GetMapping("/api/module/{id}")
	public Module findModuleById(@PathVariable("id") int id) {
		Optional<Module> data =  moduleRepository.findById(id);
		if(data.isPresent()) {
			Module m = data.get();
			return m;
		}
		return null;
	}
	
	@GetMapping("/api/course/{cid}/module")
	public List<Module> findAllModulesForCourse(@PathVariable("cid") int cid) {
		Optional<Course> data = courseRepository.findById(cid);
			if(data.isPresent()) {
				Course course = data.get();
				return course.getModules();
			}
			return null;
	}
	
	@PutMapping("/api/module/{id}")
	public Module updateModule(@PathVariable("id") int id,
			@RequestBody Module newModule) {
		return null;
	}
}
