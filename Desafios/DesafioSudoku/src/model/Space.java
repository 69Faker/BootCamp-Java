package model;

// Classe que representa uma célula do Sudoku
public class Space
{

    // Valor atual preenchido na célula (pode ser null se estiver vazio)
    private Integer actual;

    // Valor correto esperado nessa posição (solução do Sudoku)
    private final int expected;

    // Indica se a célula é fixa (faz parte do tabuleiro inicial) ou pode ser alterada
    private final boolean fixed;

    // Construtor: recebe o valor esperado e se é fixo ou não
    public Space(final int expected, final boolean fixed)
    {
        this.expected = expected;
        this.fixed = fixed;

        // Se for uma célula fixa, o valor atual já começa como o esperado
        if (fixed)
        {
            actual = expected;
        }
    }

    // Retorna o valor atual que está preenchido na célula
    public Integer getActual()
    {
        return actual;
    }

    // Define o valor atual da célula (só se não for fixa)
    public void setActual(final Integer actual)
    {
        if (fixed) return; // não altera se for uma célula fixa
        this.actual = actual;
    }

    // Limpa a célula (define o valor atual como null)
    public void clearSpace()
    {
        setActual(null);
    }

    // Retorna o valor esperado (solução correta)
    public int getExpected()
    {
        return expected;
    }

    // Informa se a célula é fixa
    public boolean isFixed()
    {
        return fixed;
    }
}
