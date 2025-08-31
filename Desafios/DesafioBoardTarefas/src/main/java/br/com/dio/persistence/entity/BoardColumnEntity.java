package br.com.dio.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardColumnEntity
{
    // Identificador único da coluna
    private Long id;

    // Nome da coluna
    private String name;

    // Ordem da coluna dentro do board
    private int order;

    // Tipo da coluna (INITIAL, FINAL, CANCEL, PENDING)
    private BoardColumnKindEnum kind;

    // Referência ao board ao qual a coluna pertence
    // Inicializado para evitar NullPointerException
    private BoardEntity board = new BoardEntity();

    // Lista de cards pertencentes a esta coluna
    // Excluída de toString e hashCode para evitar recursão infinita
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CardEntity> cards = new ArrayList<>();
}

