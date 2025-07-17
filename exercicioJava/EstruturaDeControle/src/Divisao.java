import java.util.Scanner;

public class Divisao {
    public void Calculo()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero inteiro:");
        var numeroInicial = scanner.nextInt();

        while(true)
        {
            System.out.println("Digite um numero inteiro:");
            var numeroSecundario = scanner.nextInt();
            if (numeroSecundario < numeroInicial) continue;

            if (numeroSecundario % numeroInicial != 0)
            {
                System.out.println("parabens");
                break;
            }
        }
    }
}
