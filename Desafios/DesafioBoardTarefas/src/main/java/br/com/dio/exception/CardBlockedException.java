package br.com.dio.exception;

// Exceção customizada para indicar que um card está bloqueado e não pode ser movido ou alterado
public class CardBlockedException extends RuntimeException
{
    public CardBlockedException(final String message)
    {
        super(message);
    }
}
