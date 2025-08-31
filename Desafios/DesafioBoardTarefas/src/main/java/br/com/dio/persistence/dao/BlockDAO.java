package br.com.dio.persistence.dao;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;

import static br.com.dio.persistence.converter.OffsetDateTimeConverter.toTimestamp;

@AllArgsConstructor
public class BlockDAO
{
    private final Connection connection;

    // Bloqueia um card registrando timestamp e motivo
    public void block(final String reason, final Long cardId) throws SQLException
    {
        var sql = "INSERT INTO BLOCKS (blocked_at, block_reason, card_id) VALUES (?, ?, ?);";

        try(var statement = connection.prepareStatement(sql))
        {
            var i = 1;

            // Converte OffsetDateTime para Timestamp compatível com JDBC
            statement.setTimestamp(i ++, toTimestamp(OffsetDateTime.now()));
            statement.setString(i ++, reason);
            statement.setLong(i, cardId);

            statement.executeUpdate();
        }
    }

    // Desbloqueia um card atualizando registro existente
    public void unblock(final String reason, final Long cardId) throws SQLException
    {
        var sql = "UPDATE BLOCKS SET unblocked_at = ?, unblock_reason = ? WHERE card_id = ? AND unblock_reason IS NULL;";

        try(var statement = connection.prepareStatement(sql))
        {
            var i = 1;

            // Registra o horário do desbloqueio e motivo
            statement.setTimestamp(i ++, toTimestamp(OffsetDateTime.now()));
            statement.setString(i ++, reason);
            statement.setLong(i, cardId);

            statement.executeUpdate();
        }
    }
}