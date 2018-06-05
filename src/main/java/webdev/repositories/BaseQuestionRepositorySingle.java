package webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import webdev.models.BaseExamQuestion;
import webdev.models.TrueOrFalseExamQuestion;
import webdev.models.FillInTheBlanksExamQuestion;
import webdev.models.EssayExamQuestion;

public interface BaseQuestionRepositorySingle extends CrudRepository <BaseExamQuestion, Integer>{
}

