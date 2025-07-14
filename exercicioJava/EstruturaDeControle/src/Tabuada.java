import java.util.Scanner;

public class Tabuada
{
    public int operacao()
    {
        Scanner scanner = new Scanner(System.in);

        var multiplicando = scanner.nextInt();

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++ )
        {
            var produto = multiplicando * multiplicador;

            System.out.printf("| %s X %s = %s |\n", multiplicando, multiplicador, produto);

        }

        return 0;
    }
}
