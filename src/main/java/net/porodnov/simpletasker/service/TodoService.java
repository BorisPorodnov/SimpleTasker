package net.porodnov.simpletasker.service;

import net.porodnov.simpletasker.dao.TodoDao;
import net.porodnov.simpletasker.dao.UserDao;
import net.porodnov.simpletasker.entity.TodoEntity;
import net.porodnov.simpletasker.entity.UserEntity;
import net.porodnov.simpletasker.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoDao todoDao;
    private final UserDao userDao;

    public TodoService(TodoDao todoDao, UserDao userDao) {
        this.todoDao = todoDao;
        this.userDao = userDao;
    }

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userDao.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoDao.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoDao.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoDao.save(todo));
    }
}
