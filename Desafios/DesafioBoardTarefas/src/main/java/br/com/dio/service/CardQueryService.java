package br.com.dio.service;

import br.com.dio.dto.CardDetailsDTO;
import br.com.dio.persistence.dao.CardDAO;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class CardQueryService
{
    // Injeção de dependência via construtor gerado pelo Lombok (@AllArgsConstructor),
    // útil para garantir imutabilidade e facilitar testes (mock de Connection).
    private final Connection connection;

    public Optional<CardDetailsDTO> findById(final Long id) throws SQLException
    {
        // Uso do "var" para inferência de tipo,
        // tornando o código mais conciso e legível.
        var dao = new CardDAO(connection);

        // Retorna um Optional, evitando NullPointerException
        // e obrigando o chamador a tratar o caso de ausência de resultado.
        return dao.findById(id);
    }

}
