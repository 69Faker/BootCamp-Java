package br.com.dio.dto;

import java.time.OffsetDateTime;

// DTO imutável que transporta informações detalhadas de um Card
// Inclui estado de bloqueio, histórico de bloqueios e informações da coluna atual
public record CardDetailsDTO(
        Long id,
        String title,
        String description,
        boolean blocked,
        OffsetDateTime blockedAt,
        String blockReason,
        int blocksAmount,
        Long columnId,
        String columnName
)
{
}
