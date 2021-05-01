package net.porodnov.simpletasker.controller;

import net.porodnov.simpletasker.controller.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    public ResponseEntity registration(@RequestBody UserEntity user){

        return null;
    }

    @GetMapping()

    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Cервер работает");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
