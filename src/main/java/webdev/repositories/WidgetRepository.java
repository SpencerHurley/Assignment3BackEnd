package webdev.repositories;

import webdev.models.Widget;
import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository extends CrudRepository <Widget, Integer>{

}
