package webdev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webdev.repositories.BaseQuestionRepositorySingle;
import webdev.repositories.ExamRepository;
import webdev.repositories.FillInTheBlanksRepositorySingle;
import webdev.repositories.MultipleChoiceRepositorySingle;
import webdev.repositories.TrueOrFalseRepositorySingle;
import webdev.repositories.LessonRepository;

import webdev.models.Assignment;
import webdev.models.EssayExamQuestion;
import webdev.models.Exam;
import webdev.models.FillInTheBlanksExamQuestion;
import webdev.models.Lesson;
import webdev.models.MultipleChoiceExamQuestion;
import webdev.models.TrueOrFalseExamQuestion;

@RestController
public class ServiceSingle {
  @Autowired
  BaseQuestionRepositorySingle baseRepo;
  @Autowired
  FillInTheBlanksRepositorySingle fillRepo;
  @Autowired
  TrueOrFalseRepositorySingle trueRepo; 
  @Autowired
  MultipleChoiceRepositorySingle multRepo;
  @Autowired
  ExamRepository examRepo;
  @Autowired
  LessonRepository lessonRepository;
  
  @GetMapping("/api/exam")
  public List<Exam> findAllExamQuestions() {
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
  
  @PostMapping("/api/exam/{eid}/choice")
  public void addEssayQuestionForExam(@PathVariable("eid") int eid,
		  @RequestBody MultipleChoiceExamQuestion mchoice) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(mchoice);
		}
  }
  
  @PostMapping("/api/exam/{eid}/blanks")
  public void addFillInBlanksQuestionForExam(@PathVariable("eid") int eid,
		  @RequestBody FillInTheBlanksExamQuestion blanks) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(blanks);
		}
  }
  
  @PostMapping("/api/exam/{eid}/essay")
  public void addTrueFalseForExam(@PathVariable("eid") int eid,
		  @RequestBody TrueOrFalseExamQuestion trueFalse) {
	  Optional<Exam> maybeExam = examRepo.findById(eid);
		if (maybeExam.isPresent()) {
			Exam exam = maybeExam.get();
			exam.addQuestion(trueFalse);
		}
  }
  
}

