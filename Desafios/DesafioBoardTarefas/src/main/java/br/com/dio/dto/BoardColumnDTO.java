package br.com.dio.dto;

import br.com.dio.persistence.entity.BoardColumnKindEnum;

// DTO imutável que transporta informações resumidas de uma coluna do Board
// Inclui tipo da coluna e quantidade de cards, útil para visualização e lógica de fluxo
public record BoardColumnDTO(
        Long id,
        String name,
        BoardColumnKindEnum kind,
        int cardsAmount
)
{
}
