package model;

import java.util.Collection;
import java.util.List;

import static model.GameStatusEnum.COMPLETE;
import static model.GameStatusEnum.INCOMPLETE;
import static model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

// Classe que representa o tabuleiro do Sudoku
public class Board
{

    // Matriz (9x9) de espaços (células do Sudoku)
    // Cada Space pode ser fixo ou editável
    private final List<List<Space>> spaces;

    // Construtor recebe a matriz de espaços
    public Board(final List<List<Space>> spaces)
    {
        this.spaces = spaces;
    }

    // Getter para acessar a matriz de espaços
    public List<List<Space>> getSpaces()
    {
        return spaces;
    }

    // Retorna o status atual do jogo
    // Pode ser: NON_STARTED, INCOMPLETE ou COMPLETE
    public GameStatusEnum getStatus()
    {
        // Se não existe nenhuma célula preenchida pelo usuário (todas fixas ou nulas),
        // o jogo nunca começou (NON_STARTED)
        if (spaces.stream()
                .flatMap(Collection::stream) // transforma a matriz em uma stream linear
                .noneMatch(s -> !s.isFixed() && nonNull(s.getActual())))
        {
            return NON_STARTED;
        }

        // Caso contrário: se ainda existem células vazias, jogo está INCOMPLETE
        // Senão, está COMPLETE
        return spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    // Verifica se existem erros no tabuleiro
    // Ou seja, se algum valor atual não corresponde ao valor esperado
    public boolean hasErrors(){
        // Se o jogo não começou, não há erros
        if(getStatus() == NON_STARTED)
        {
            return false;
        }

        // Procura células que não sejam nulas e estejam erradas
        return spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }

    // Tenta mudar o valor de uma célula
    // Retorna false se for célula fixa (não pode ser alterada)
    public boolean changeValue(final int col, final int row, final int value)
    {
        var space = spaces.get(col).get(row);
        if (space.isFixed())
        {
            return false;
        }

        space.setActual(value);
        return true;
    }

    // Tenta apagar o valor de uma célula
    // Retorna false se for célula fixa
    public boolean clearValue(final int col, final int row)
    {
        var space = spaces.get(col).get(row);
        if (space.isFixed())
        {
            return false;
        }

        space.clearSpace();
        return true;
    }

    // Reseta o tabuleiro inteiro, limpando todos os valores (mesmo os fixos)
    public void reset()
    {
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    // Verifica se o jogo terminou com sucesso
    // Precisa estar COMPLETO e sem erros
    public boolean gameIsFinished()
    {
        return !hasErrors() && getStatus().equals(COMPLETE);
    }

}
