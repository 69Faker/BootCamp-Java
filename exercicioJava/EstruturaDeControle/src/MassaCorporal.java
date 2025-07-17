//@exercicio: Escreva um código onde o usuário entra com sua altura e peso, seja feito o calculo do seu IMC(IMC = peso/(altura * altura)) e seja exibida a mensagem de acordo com o resultado

import java.util.Scanner;

public class MassaCorporal
{
    public void calcular()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua altura:");
        var altura = scanner.nextFloat();

        System.out.println("Digite seu peso:");
        var peso = scanner.nextFloat();
        float imc = peso / (altura * altura);

        if (imc <= 18.5)
        {
            System.out.printf("IMC: %s\n", imc);
            System.out.println("Abaixo do peso");
        }
        else if (imc >= 18.6 && imc <= 24.9 )
        {
            System.out.printf("IMC: %s\n", imc);
            System.out.println("Peso ideal");
        }
        else if (imc >= 25.0 && imc <= 29.9)
        {
            System.out.printf("IMC: %s\n", imc);
            System.out.println("Levemente acima do peso");
        }
        else if (imc >= 30.0 && imc <= 34.9)
        {
            System.out.printf("IMC: %s\n", imc);
            System.out.println("Obesidae Grau 1");
        }
        else if (imc >= 35.0 && imc <= 39.9)
        {
            System.out.printf("IMC: %s\n", imc);
            System.out.println("Obesidade Grau 2 (Severa)");
        }
        else if (imc >= 40.0)
        {
            System.out.printf("IMC: %s\n", imc);
            System.out.println("Obesidade Grau 3 (Mórbida)");
        }

    }

}
