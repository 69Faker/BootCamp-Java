package br.com.dio.persistence.entity;

import java.util.stream.Stream;

public enum BoardColumnKindEnum
{
    INITIAL, FINAL, CANCEL, PENDING;

    // Método utilitário para buscar o enum pelo nome
    // Usa Stream para percorrer os valores e encontrar correspondência
    // Lança exceção se não encontrar, evitando retorno nulo
    public static BoardColumnKindEnum findByName(final String name)
    {
        return Stream.of(BoardColumnKindEnum.values())
                .filter(b -> b.name().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
