package candidatura;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo
{
    static void selecaoCandidatos()
    {
        String [] candidatos ={"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length)
        {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato" + candidato + " Solicitou este valor de salário " + salarioPretendido);

            if (salarioBase >= salarioPretendido)
            {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;

        }
        System.out.println("Candidatos selecionados: " + candidatosSelecionados);
    }

    static double valorPretendido()
    {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato (double salarioPretendido)
    {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido)
        {
            System.out.println("Ligar para candidato");
        }
        else if (salarioBase == salarioPretendido)
        {
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else
        {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
