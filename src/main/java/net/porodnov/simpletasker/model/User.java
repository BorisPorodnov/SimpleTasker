package net.porodnov.simpletasker.model;

import net.porodnov.simpletasker.entity.UserEntity;

public class User {

    private Long id;
    private String name;

    public static User toModel(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setName(userEntity.getUsername());
        return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
