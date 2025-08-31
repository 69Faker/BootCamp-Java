package me.thiago.service;

import me.thiago.domain.model.User;

// Interface de serviço para operações com User
public interface UserService
{
    User findById(Long id);

    User create(User userToCreate);
}
