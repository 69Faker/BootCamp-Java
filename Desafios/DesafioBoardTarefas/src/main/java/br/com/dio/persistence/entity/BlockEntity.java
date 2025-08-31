package br.com.dio.persistence.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BlockEntity
{
    // Identificador único do bloqueio
    private Long id;

    // Data e hora do bloqueio do card
    private OffsetDateTime blockedAt;

    // Motivo do bloqueio
    private String blockReason;

    // Data e hora do desbloqueio do card
    private OffsetDateTime unblockedAt;

    // Motivo do desbloqueio
    private String unblockReason;
}
