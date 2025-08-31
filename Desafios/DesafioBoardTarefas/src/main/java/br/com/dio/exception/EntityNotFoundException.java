package br.com.dio.exception;

// Exceção customizada para indicar que uma entidade não foi encontrada no banco ou sistema
public class EntityNotFoundException extends RuntimeException
{
    public EntityNotFoundException(String message)
    {
        super(message);
    }
}
