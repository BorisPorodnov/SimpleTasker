package net.porodnov.simpletasker.dao;

import net.porodnov.simpletasker.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<TodoEntity, Long> {

}
