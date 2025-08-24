public class Main
{
    public static void main (String[] args)
    {
        Cliente thiago = new Cliente();
        thiago.setNome("Thiago");

        Conta cc = new ContaCorrente(thiago);
        Conta poupanca = new ContaPoupanca(thiago);

        cc.depositar(200);
        cc.transferir(150, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}