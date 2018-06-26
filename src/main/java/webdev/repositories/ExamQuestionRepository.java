package webdev.repositories;

import org.springframework.data.repository.CrudRepository;

import webdev.models.BaseExamQuestion;

public interface ExamQuestionRepository extends CrudRepository <BaseExamQuestion, Integer>{
}