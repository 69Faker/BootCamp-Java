//@exercicio: Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números, a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha resto diferente de 0 na divisão, números menores que o primeiro número devem ser ignorados.

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
