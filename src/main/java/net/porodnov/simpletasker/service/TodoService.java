package net.porodnov.simpletasker.service;

import net.porodnov.simpletasker.dao.TodoDao;
import net.porodnov.simpletasker.dao.UserDao;
import net.porodnov.simpletasker.entity.TodoEntity;
import net.porodnov.simpletasker.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoDao todoDao;
    private final UserDao userDao;

    public TodoService(TodoDao todoDao, UserDao userDao) {
        this.todoDao = todoDao;
        this.userDao = userDao;
    }

    public Object createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userDao.findById(userId).get();
        todo.setUser(user);
        return todoDao.save(todo);
    }

    public Object complete(Long id) {
        TodoEntity todo = (TodoEntity) todoDao.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return todoDao.save(todo);
    }
}
