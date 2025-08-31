package br.com.dio.exception;

// Exceção customizada para indicar que um card já foi finalizado e não pode sofrer alterações de fluxo
public class CardFinishedException extends RuntimeException
{
    public CardFinishedException(final String message)
    {
        super(message);
    }
}
