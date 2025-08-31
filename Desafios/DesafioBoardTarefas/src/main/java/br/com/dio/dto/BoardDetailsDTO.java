package br.com.dio.dto;

import java.util.List;

// DTO imutável que representa detalhes completos de um Board
// Contém ID, nome e lista de colunas com seus detalhes, útil para exibição consolidada
public record BoardDetailsDTO(
        Long id,
        String name,
        List<BoardColumnDTO> columns
)
{
}