package webdev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webdev.repositories.ExamQuestionRepository;
import webdev.repositories.ExamRepository;
import webdev.repositories.LessonRepository;
import webdev.models.BaseExamQuestion;
import webdev.models.EssayExamQuestion;
import webdev.models.Exam;
import webdev.models.FillInTheBlanksQuestion;
import webdev.models.Lesson;
import webdev.models.MultipleChoiceQuestion;
import webdev.models.TrueFalseQuestion;

@RestController
@CrossOrigin(origins = "*")
public class ExamService {
  @Autowired
  ExamQuestionRepository questionRepo;
  
  @Autowired
  ExamRepository examRepo;
  
  @Autowired
  LessonRepository lessonRepository;
  
  @GetMapping("/api/exam")
  public List<Exam> findAllExams() {
	  return (List<Exam>) examRepo.findAll();
  }
  
  @GetMapping("/api/exam/{eid}")
  public Exam findExamById(@PathVariable("eid") int eid) {
	  Optional<Exam> exam = examRepo.findById(eid);
		if (exam.isPresent()) {
			return exam.get();
		}
		return null;
  }
  
  
  @GetMapping("/api/lesson/{lid}/exam")
  public List<Exam> findExamsForLesson(@PathVariable("lid") int lid) {
		Optional<Lesson> maybeLesson = lessonRepository.findById(lid);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			return lesson.getExams();
		}
		return null;
	}
  
  @PostMapping("/api/exam")
  public void createExam(@RequestBody Exam exam) {
	  examRepo.save(exam);
  }
  
  @PostMapping("/api/lesson/{lid}/exam")
  public Exam addExamToLesson(@PathVariable("lid") int lid,
		  @RequestBody Exam exam) {
	  Optional<Lesson> maybeLesson = lessonRepository.findById(lid);
		if (maybeLesson.isPresent()) {
			Lesson lesson = maybeLesson.get();
			lesson.addExam(exam);
		}
		return null;
  }
  
  @DeleteMapping("/api/exam/{eid}")
  public void deleteExamById(@PathVariable("eid") int eid) {
	  examRepo.deleteById(eid);
  }
  
  @PostMapping("/api/exam/{eid}/essay")
  public void addEssayQuestionForExam(@PathVariable("eid") int eid,
		  @RequestBody EssayExamQuestion essay) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(essay);
		}
  }
  
  @PostMapping("/api/exam/{eid}/question")
  public void addQuestionForExam(@PathVariable("eid") int eid,
		  @RequestBody BaseExamQuestion essay) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(essay);
		}
  }

  
  @PostMapping("/api/exam/{eid}/blanks")
  public void addFillInBlanksQuestionForExam(@PathVariable("eid") int eid,
		  @RequestBody FillInTheBlanksQuestion blanks) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(blanks);
		}
  }
  
  @PostMapping("/api/exam/{eid}/tf")
  public void addTrueFalseForExam(@PathVariable("eid") int eid,
		  @RequestBody TrueFalseQuestion trueFalse) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(trueFalse);
		}
  }
  
  @PostMapping("/api/exam/{eid}/mult")
  public void addMultChoiceForExam(@PathVariable("eid") int eid,
		  @RequestBody MultipleChoiceQuestion multChoice) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(multChoice);
		}
  }
  
}
