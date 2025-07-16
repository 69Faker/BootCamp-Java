import java.util.Scanner;

public class ParImpar
{
    public void ListaNumeros()
    {
        Scanner scanner = new Scanner(System.in);

        int numero1;
        int numero2;

        System.out.println("Digite um número inteiro:");
        numero1 = scanner.nextInt();

        do
        {
            System.out.println("Digite outro número inteiro que seja maior que o anterior:");
            numero2 = scanner.nextInt();
        } while (numero2 <= numero1);

        System.out.println("Escolha uma opção | Par = 0 ou Ímpar = 1");
        int opcao = scanner.nextInt();

        while (opcao != 0 && opcao != 1)
        {
            System.out.println("Escolha uma opção válida | Par = 0 ou Ímpar = 1");
            opcao = scanner.nextInt();
        }

        if (opcao == 0)
        {
            System.out.println("Números pares:");
            for (int i = numero2; i >= numero1; i--)
            {
                if (i % 2 == 0)
                {
                    System.out.println(i);
                }
            }
        }
        else
        {
            System.out.println("Números ímpares:");
            for (int i = numero2; i >= numero1; i--)
            {
                if (i % 2 != 0)
                {
                    System.out.println(i);
                }
            }
        }
    }
}