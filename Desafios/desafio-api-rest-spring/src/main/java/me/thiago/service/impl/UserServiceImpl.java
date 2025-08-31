package me.thiago.service.impl;

import me.thiago.domain.model.User;
import me.thiago.domain.repository.UserRepository;
import me.thiago.service.UserService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
// Implementação da interface UserService
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id)
    {
        // Busca usuário por ID e lança exceção se não existir
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate)
    {
        // Validação: impede criação de usuário com conta duplicada
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()))
        {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        // Persiste o usuário no banco de dados
        return userRepository.save(userToCreate);
    }
}
