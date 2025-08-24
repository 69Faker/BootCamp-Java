public abstract class Conta implements IConta
{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente)
    {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(double valor)
    {
        if(valor <= 0)
        {
            System.out.println("Valor de saque inválido.");
            return;
        }

        if(saldo >= valor)
        {
            saldo -= valor;
            System.out.println("Saque realizado: " + valor);
        }
        else
        {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor)
    {
        if(valor <= 0)
        {
            System.out.println("Valor de depósito inválido.");
            return;
        }

        saldo += valor;
        System.out.println("Depósito realizado: " + valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino)
    {
        if(valor <= 0)
        {
            System.out.println("Valor de transferência inválido.");
            return;
        }

        if(saldo >= valor)
        {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada: " + valor + " para conta " + contaDestino.getNumero());
        }
        else
        {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public int getAgencia()
    {
        return agencia;
    }

    public int getNumero()
    {
        return numero;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    protected void imprimirInfosComuns()
    {
        System.out.printf("Titular: %s\n", this.cliente.getNome());
        System.out.printf("Agencia: %d\n", this.agencia);
        System.out.printf("Número: %d\n", this.numero);
        System.out.printf("Saldo: %.2f\n", this.saldo);
    }

    @Override
    public abstract void imprimirExtrato();
}
