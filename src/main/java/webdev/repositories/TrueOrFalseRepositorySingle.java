package webdev.repositories;
import org.springframework.data.repository.CrudRepository;

import webdev.models.TrueOrFalseExamQuestion;

public interface TrueOrFalseRepositorySingle extends CrudRepository 
<TrueOrFalseExamQuestion, Integer>{}
