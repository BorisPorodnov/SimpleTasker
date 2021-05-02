package net.porodnov.simpletasker.dao;

import net.porodnov.simpletasker.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String name);

}
