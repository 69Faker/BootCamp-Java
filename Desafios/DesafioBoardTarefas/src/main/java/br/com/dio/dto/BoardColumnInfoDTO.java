package br.com.dio.dto;

import br.com.dio.persistence.entity.BoardColumnKindEnum;

// DTO leve que transporta informações essenciais de uma coluna do Board
// Usado principalmente para operações de lógica de negócio, como movimentação de cards
public record BoardColumnInfoDTO(
        Long id,
        int order,
        BoardColumnKindEnum kind
)
{
}
