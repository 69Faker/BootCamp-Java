import java.util.Scanner;

public class Contador
{
    public static void main(String[] args)
    {
        Scanner terminal = new Scanner(System.in);
        while (true)
        {
            System.out.println("Digite o primeiro parâmetro:");
            int parametroUm = terminal.nextInt();

            System.out.println("Digite o segundo parâmetro:");
            int parametroDois = terminal.nextInt();

            try
            {
                contar(parametroUm, parametroDois);
                break;
            } catch (ParametrosInvalidosException e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        terminal.close();
    }
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException
    {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção

        if (parametroUm > parametroDois)
        {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        for (int indice = 1; indice <= contagem; indice++ )
        {
                System.out.println("Imprimindo o número " + indice);
        }
    }
}