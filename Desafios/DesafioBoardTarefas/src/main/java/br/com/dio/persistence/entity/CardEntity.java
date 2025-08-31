package br.com.dio.persistence.entity;

import lombok.Data;

@Data
public class CardEntity
{
    // Identificador único do card
    private Long id;

    // Título do card (campo obrigatório para criação)
    private String title;

    // Descrição detalhada do card
    private String description;

    // Associação com a coluna do board onde o card está atualmente
    // Inicializado para evitar NullPointerException
    private BoardColumnEntity boardColumn = new BoardColumnEntity();
}
