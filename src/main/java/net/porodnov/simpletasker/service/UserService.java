package net.porodnov.simpletasker.service;

import net.porodnov.simpletasker.entity.UserEntity;
import net.porodnov.simpletasker.dao.UserDao;
import net.porodnov.simpletasker.exceptions.UserAlreadyExistException;
import net.porodnov.simpletasker.exceptions.UserNotFoundException;
import net.porodnov.simpletasker.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userDao.findByUsername(userEntity.getUsername()) != null)
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        return userDao.save(userEntity);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userDao.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userDao.deleteById(id);
        return id;
    }
}
