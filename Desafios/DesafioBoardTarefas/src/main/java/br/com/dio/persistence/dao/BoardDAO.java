package br.com.dio.persistence.dao;

import br.com.dio.persistence.entity.BoardEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardDAO
{
    private Connection connection;

    // Insere um novo board no banco
    public BoardEntity insert(final BoardEntity entity) throws SQLException
    {
        var sql = "INSERT INTO BOARDS (name) values (?);";

        try(var statement = connection.prepareStatement(sql))
        {
            statement.setString(1, entity.getName());
            statement.executeUpdate();

            // Recupera o ID gerado pelo banco usando StatementImpl (MySQL)
            if (statement instanceof StatementImpl impl)
            {
                entity.setId(impl.getLastInsertID());
            }
        }

        return entity;
    }

    // Exclui um board pelo ID
    public void delete(final Long id) throws SQLException
    {
        var sql = "DELETE FROM BOARDS WHERE id = ?;";

        try(var statement = connection.prepareStatement(sql))
        {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    // Busca um board pelo ID
    public Optional<BoardEntity> findById(final Long id) throws SQLException
    {
        var sql = "SELECT id, name FROM BOARDS WHERE id = ?;";

        try(var statement = connection.prepareStatement(sql))
        {
            statement.setLong(1, id);
            statement.executeQuery();

            var resultSet = statement.getResultSet();

            if (resultSet.next())
            {
                var entity = new BoardEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));

                return Optional.of(entity);
            }

            return Optional.empty();
        }
    }

    // Verifica se o board existe pelo ID
    public boolean exists(final Long id) throws SQLException
    {
        var sql = "SELECT 1 FROM BOARDS WHERE id = ?;";

        try(var statement = connection.prepareStatement(sql))
        {
            statement.setLong(1, id);
            statement.executeQuery();

            // Retorna true se a query retornar pelo menos uma linha
            return statement.getResultSet().next();
        }
    }
}
