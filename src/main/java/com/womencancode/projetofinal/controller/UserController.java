package com.womencancode.projetofinal.controller;

import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping //inserir no banco de dados um usuário por vez
    //ResponseEntity garante que o serviço tenha resposta completa, com status, cabeçalho e corpo
    public ResponseEntity<User> insertUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.insertUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) throws Exception {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping
    public ResponseEntity<Stream<User>> getAll(@SortDefault.SortDefaults(
            {@SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable).get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws Exception {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
