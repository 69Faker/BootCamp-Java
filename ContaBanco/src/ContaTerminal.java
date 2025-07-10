import java.util.Scanner;

public class ContaTerminal
{

    public void executar()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, digite seu nome:");
        var nome = scanner.next();

        System.out.println("Digite o número da sua conta:");
        var numero = scanner.nextInt();

        System.out.println("Digite a sua agência:");
        var agencia = scanner.next();

        System.out.println("Deseja realizar um depósito em sua nova conta? (true/false)");
        var deposito = scanner.nextBoolean();

        if (deposito)
        {
            System.out.println("Digite a quantia que deseja depositar:");
            var saldo = scanner.nextFloat();
            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo é R$%.2f já está disponível para saque", nome, agencia, numero, saldo);
        } else
        {
            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo é R$0.00 sua conta já está liberada!", nome, agencia, numero);
        }

        scanner.close();
    }
}
