package br.com.dio.service;

import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.entity.BoardColumnEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardColumnQueryService
{
    // Injeção de dependência via construtor, facilita testes e garante imutabilidade
    private final Connection connection;

    public Optional<BoardColumnEntity> findById(final Long id) throws SQLException
    {
        var dao = new BoardColumnDAO(connection);

        // Retorna Optional para tratamento seguro da ausência de coluna
        return dao.findById(id);
    }
}
