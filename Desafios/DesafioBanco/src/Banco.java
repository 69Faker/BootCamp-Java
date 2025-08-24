import java.util.ArrayList;
import java.util.List;

public class Banco
{
    private String nome;
    private List<Conta> contas;

    public Banco(String nome)
    {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public List<Conta> getContas()
    {
        return new ArrayList<>(contas);
    }

    public ContaCorrente abrirContaCorrente(Cliente cliente)
    {
        ContaCorrente cc = new ContaCorrente(cliente);
        contas.add(cc);
        return cc;
    }

    public ContaPoupanca abrirContaPoupanca(Cliente cliente)
    {
        ContaPoupanca cp = new ContaPoupanca(cliente);
        contas.add(cp);
        return cp;
    }

    public Conta buscarContaPorNumero(int numero)
    {
        for(Conta c : contas)
        {
            if(c.getNumero() == numero)
            {
                return c;
            }
        }
        return null;
    }

    public List<Conta> listarContasCliente(Cliente cliente)
    {
        List<Conta> resultado = new ArrayList<>();
        for(Conta c : contas)
        {
            if(c.getCliente().equals(cliente))
            {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
