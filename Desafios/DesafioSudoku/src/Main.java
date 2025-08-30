import model.Board;
import model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static util.BoardTemplate.BOARD_TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

public class Main
{

    // Scanner global para entrada de dados do usuário
    private final static Scanner scanner = new Scanner(System.in);

    // Objeto principal que representa o tabuleiro do Sudoku
    private static Board board;

    // Constante que define o tamanho do tabuleiro (9x9)
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args)
    {
        // Converte os argumentos de linha de comando em um mapa
        // Cada argumento deve ser no formato "linha,coluna;valor,fixed"
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0], // chave: "linha,coluna"
                        v -> v.split(";")[1]  // valor: "valor,fixed"
                ));

        var option = -1;

        // Loop principal do menu do jogo
        while (true)
        {
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            // Menu de seleção usando switch expression (Java 14+)
            switch (option)
            {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida, selecione uma das opções do menu");
            }
        }
    }

    // Inicializa o jogo, criando o tabuleiro a partir das posições recebidas
    private static void startGame(final Map<String, String> positions)
    {
        if (nonNull(board))
        { // impede reiniciar se já existe jogo iniciado
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();

        // Cria as 9 linhas do tabuleiro
        for (int i = 0; i < BOARD_LIMIT; i++)
        {
            spaces.add(new ArrayList<>());

            // Cria as 9 colunas em cada linha
            for (int j = 0; j < BOARD_LIMIT; j++)
            {
                var positionConfig = positions.get("%s,%s".formatted(i, j));

                // Divide a string "valor,fixed" em dois elementos
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);

                // Cria a célula (Space) do Sudoku
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar");
    }

    // Permite ao usuário inserir um número em uma célula
    private static void inputNumber()
    {
        if (isNull(board))
        {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Informe a coluna que em que o número será inserido");
        var col = runUntilGetValidNumber(0, 8);

        System.out.println("Informe a linha que em que o número será inserido");
        var row = runUntilGetValidNumber(0, 8);

        System.out.printf("Informe o número que vai entrar na posição [%s,%s]\n", col, row);
        var value = runUntilGetValidNumber(1, 9);

        // Tenta alterar o valor da célula
        if (!board.changeValue(col, row, value)){
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        }
    }

    // Permite ao usuário remover um número de uma célula
    private static void removeNumber()
    {
        if (isNull(board))
        {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Informe a coluna que em que o número será inserido");
        var col = runUntilGetValidNumber(0, 8);

        System.out.println("Informe a linha que em que o número será inserido");
        var row = runUntilGetValidNumber(0, 8);

        // Só remove se não for valor fixo
        if (!board.clearValue(col, row))
        {
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        }
    }

    // Mostra o estado atual do tabuleiro
    private static void showCurrentGame()
    {
        if (isNull(board))
        {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        var args = new Object[81];
        var argPos = 0;

        // Percorre as linhas e colunas do tabuleiro
        for (int i = 0; i < BOARD_LIMIT; i++)
        {
            for (var col: board.getSpaces())
            {
                // Substitui null por espaço em branco
                args[argPos ++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }

        // Exibe formatado com template definido em BOARD_TEMPLATE
        System.out.println("Seu jogo se encontra da seguinte forma");
        System.out.printf((BOARD_TEMPLATE) + "\n", args);
    }

    // Mostra se o jogo está correto, incompleto ou com erros
    private static void showGameStatus()
    {
        if (isNull(board))
        {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.printf("O jogo atualmente se encontra no status %s\n", board.getStatus().getLabel());

        if(board.hasErrors())
        {
            System.out.println("O jogo contém erros");
        } else
        {
            System.out.println("O jogo não contém erros");
        }
    }

    // Reseta o jogo, apagando todo o progresso
    private static void clearGame()
    {
        if (isNull(board))
        {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Tem certeza que deseja limpar seu jogo e perder todo seu progresso?");
        var confirm = scanner.next();

        // Só aceita "sim" ou "não"
        while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não"))
        {
            System.out.println("Informe 'sim' ou 'não'");
            confirm = scanner.next();
        }

        if(confirm.equalsIgnoreCase("sim"))
        {
            board.reset();
        }
    }

    // Finaliza o jogo se estiver concluído corretamente
    private static void finishGame()
    {
        if (isNull(board))
        {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        if (board.gameIsFinished())
        {
            System.out.println("Parabéns você concluiu o jogo");
            showCurrentGame();
            board = null; // limpa o tabuleiro para reiniciar
        } else if (board.hasErrors())
        {
            System.out.println("Seu jogo conté, erros, verifique seu board e ajuste-o");
        } else
        {
            System.out.println("Você ainda precisa preenhcer algum espaço");
        }
    }

    // Método utilitário para garantir que o usuário digite número válido dentro do intervalo
    private static int runUntilGetValidNumber(final int min, final int max){
        var current = scanner.nextInt();
        while (current < min || current > max)
        {
            System.out.printf("Informe um número entre %s e %s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }

}
