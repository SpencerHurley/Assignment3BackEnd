package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import webdev.repositories.BaseQuestionRepositorySingle;
import webdev.repositories.FillInTheBlanksRepositorySingle;
import webdev.repositories.MultipleChoiceRepositorySingle;
import webdev.repositories.TrueOrFalseRepositorySingle;

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
  
  @GetMapping("/api/exam")
  public List<BaseExamQuestion> createBaseQuestion() {
	  
  }
  @GetMapping("/api/inheritance/single/fill")
  public FillInTheBlankQuestionSingle 
  createFillQuestion() {...}
  @GetMapping("/api/inheritance/single/true")
  public TrueOrFalseQuestionSingle 
  createTrueQuestion() {...}

  
  
}

