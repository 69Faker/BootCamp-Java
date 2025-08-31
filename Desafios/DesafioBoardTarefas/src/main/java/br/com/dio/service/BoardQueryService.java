package br.com.dio.service;

import br.com.dio.dto.BoardDetailsDTO;
import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.dao.BoardDAO;
import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardQueryService
{
    private final Connection connection;

    public Optional<BoardEntity> findById(final Long id) throws SQLException
    {
        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);

        // Busca uma BoardEntity no banco pelo ID
        var optional = dao.findById(id);

        // Se a BoardEntity existir, carrega também suas colunas associadas
        if (optional.isPresent())
        {
            var entity = optional.get();

            // Preenche a entidade com as colunas do board (lazy loading manual)
            entity.setBoardColumns(boardColumnDAO.findByBoardId(entity.getId()));

            return Optional.of(entity);
        }

        return Optional.empty();
    }

    public Optional<BoardDetailsDTO> showBoardDetails(final Long id) throws SQLException
    {
        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);

        // Busca a entidade Board no banco
        var optional = dao.findById(id);

        if (optional.isPresent())
        {
            var entity = optional.get();

            // Busca as colunas com mais detalhes associados, enriquecendo o DTO
            var columns = boardColumnDAO.findByBoardIdWithDetails(entity.getId());

            // Constrói um DTO especializado para exibição de detalhes
            var dto = new BoardDetailsDTO(entity.getId(), entity.getName(), columns);

            return Optional.of(dto);
        }

        return Optional.empty();
    }
}
