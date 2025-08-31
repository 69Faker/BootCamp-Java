package br.com.dio.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static br.com.dio.persistence.entity.BoardColumnKindEnum.CANCEL;
import static br.com.dio.persistence.entity.BoardColumnKindEnum.INITIAL;

@Data
public class BoardEntity
{
    // Identificador único do board
    private Long id;

    // Nome do board
    private String name;

    // Lista de colunas associadas ao board
    // Excluída de toString e hashCode para evitar recursão infinita
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<BoardColumnEntity> boardColumns = new ArrayList<>();

    // Retorna a coluna inicial do board
    public BoardColumnEntity getInitialColumn()
    {
        // Uso de Predicate para filtragem funcional
        return getFilteredColumn(bc -> bc.getKind().equals(INITIAL));
    }

    // Retorna a coluna de cancelamento do board
    public BoardColumnEntity getCancelColumn()
    {
        return getFilteredColumn(bc -> bc.getKind().equals(CANCEL));
    }

    // Método privado para buscar a primeira coluna que satisfaça o filtro
    // Lança exceção se nenhuma coluna for encontrada, garantindo integridade do board
    private BoardColumnEntity getFilteredColumn(Predicate<BoardColumnEntity> filter)
    {
        return boardColumns.stream()
                .filter(filter)
                .findFirst()
                .orElseThrow();
    }
}

