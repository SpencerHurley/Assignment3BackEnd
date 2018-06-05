package webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import webdev.models.MultipleChoiceExamQuestion;

public interface MultipleChoiceRepositorySingle extends CrudRepository<MultipleChoiceExamQuestion, Integer>{

}
