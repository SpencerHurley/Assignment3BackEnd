package webdev.repositories;

public interface BaseQuestionRepositorySingle
  extends CrudRepository
<BaseExamQuestion, Integer>{}
public interface TrueOrFalseQuestionRepositorySingle
  extends CrudRepository
<TrueOrFalseQuestionSingle, Integer>{}
public interface FillInTheBlankQuestionRepositorySingle
  extends CrudRepository
<FillInTheBlankQuestionSingle, Integer>{}
