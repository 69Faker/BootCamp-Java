package br.com.dio.service;

import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.dao.BoardDAO;
import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardService
{
    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException
    {
        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);

        try
        {
            dao.insert(entity);

            // Uso de stream + map para associar cada coluna ao board antes da persistência.
            // Essa técnica é mais declarativa que um for tradicional, aproveitando a API funcional do Java.
            var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();

            // Persistência de cada coluna associada ao board recém-criado.
            for (var column : columns)
            {
                boardColumnDAO.insert(column);
            }

            // Garantindo atomicidade via commit após todas as inserções.
            connection.commit();
        }
        catch (SQLException e)
        {
            // Em caso de falha, rollback assegura consistência transacional.
            connection.rollback();
            throw e;
        }

        return entity;
    }

    public boolean delete(final Long id) throws SQLException
    {
        var dao = new BoardDAO(connection);

        try
        {
            // Verificação prévia para evitar exceções de integridade
            // caso a entidade não exista.
            if (!dao.exists(id))
            {
                return false;
            }

            dao.delete(id);
            connection.commit();
            return true;
        }
        catch (SQLException e)
        {
            connection.rollback();
            throw e;
        }
    }

}
