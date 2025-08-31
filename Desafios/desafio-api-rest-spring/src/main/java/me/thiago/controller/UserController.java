package me.thiago.controller;

import me.thiago.domain.model.User;
import me.thiago.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
// Define o endpoint base para esta controller
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    // Busca usuário pelo ID, retorna 200 OK se encontrado
    public ResponseEntity<User> findById(@PathVariable Long id)
    {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    // Cria um novo usuário e retorna 201 Created com a URI do recurso criado
    public ResponseEntity<User> create(@RequestBody User userToCreate)
    {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
