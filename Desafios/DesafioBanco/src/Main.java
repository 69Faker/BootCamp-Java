import java.util.Scanner;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Banco banco = new Banco("Meu Banco");
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        while(true)
        {
            System.out.println("\n=== Sistema Bancário ===");
            System.out.println("1 - Criar cliente");
            System.out.println("2 - Abrir conta corrente");
            System.out.println("3 - Abrir conta poupança");
            System.out.println("4 - Depositar");
            System.out.println("5 - Sacar");
            System.out.println("6 - Transferir");
            System.out.println("7 - Consultar extrato");
            System.out.println("8 - Listar contas do cliente");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // consumir enter

            switch(opcao)
            {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = sc.nextLine();
                    cliente = new Cliente();
                    cliente.setNome(nome);
                    System.out.println("Cliente criado com sucesso!");
                    break;

                case 2:
                    if(cliente == null)
                    {
                        System.out.println("Crie um cliente antes de abrir uma conta!");
                        break;
                    }
                    Conta cc = banco.abrirContaCorrente(cliente);
                    System.out.println("Conta corrente criada! Número: " + cc.getNumero());
                    break;

                case 3:
                    if(cliente == null)
                    {
                        System.out.println("Crie um cliente antes de abrir uma conta!");
                        break;
                    }
                    Conta cp = banco.abrirContaPoupanca(cliente);
                    System.out.println("Conta poupança criada! Número: " + cp.getNumero());
                    break;

                case 4:
                    System.out.print("Digite o número da conta: ");
                    int numDep = sc.nextInt();
                    Conta contaDep = banco.buscarContaPorNumero(numDep);
                    if(contaDep != null)
                    {
                        System.out.print("Digite o valor a depositar: ");
                        double valDep = sc.nextDouble();
                        contaDep.depositar(valDep);
                    }
                    else
                    {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 5:
                    System.out.print("Digite o número da conta: ");
                    int numSac = sc.nextInt();
                    Conta contaSac = banco.buscarContaPorNumero(numSac);
                    if(contaSac != null)
                    {
                        System.out.print("Digite o valor a sacar: ");
                        double valSac = sc.nextDouble();
                        contaSac.sacar(valSac);
                    }
                    else
                    {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 6:
                    System.out.print("Digite o número da conta de origem: ");
                    int numOrig = sc.nextInt();
                    System.out.print("Digite o número da conta de destino: ");
                    int numDest = sc.nextInt();
                    Conta contaOrig = banco.buscarContaPorNumero(numOrig);
                    Conta contaDest = banco.buscarContaPorNumero(numDest);
                    if(contaOrig != null && contaDest != null)
                    {
                        System.out.print("Digite o valor da transferência: ");
                        double valTrans = sc.nextDouble();
                        contaOrig.transferir(valTrans, contaDest);
                    }
                    else
                    {
                        System.out.println("Conta de origem ou destino não encontrada!");
                    }
                    break;

                case 7:
                    System.out.print("Digite o número da conta: ");
                    int numExt = sc.nextInt();
                    Conta contaExt = banco.buscarContaPorNumero(numExt);
                    if(contaExt != null)
                    {
                        contaExt.imprimirExtrato();
                    }
                    else
                    {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 8:
                    if(cliente == null)
                    {
                        System.out.println("Crie um cliente primeiro!");
                        break;
                    }
                    List<Conta> contasCliente = banco.listarContasCliente(cliente);
                    if(contasCliente.isEmpty())
                    {
                        System.out.println("Cliente não possui contas.");
                    }
                    else
                    {
                        System.out.println("Contas do cliente:");
                        for(Conta c : contasCliente)
                        {
                            System.out.println("Número: " + c.getNumero() + " | Saldo: " + c.getSaldo());
                        }
                    }
                    break;

                case 9:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
