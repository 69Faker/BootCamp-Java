package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static candidatura.ProcessoSeletivo.entrandoEmContato;
import static candidatura.ProcessoSeletivo.selecaoCandidatos;

public class Main
{
    public static void main(String[] args)
    {
        String [] Candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
        for(String Candidato: Candidatos)
        {
            entrandoEmContato(Candidato);
        }
    }

    static void entrandoEmContato(String candidato)
    {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do
        {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
            {
                tentativasRealizadas++;
            }
            else
            {
                System.out.println("Contato realizado com sucesso");
            }

        }while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
        {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        }
        else
        {
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas + " realizada");
        }
    }

    static boolean atender ()
    {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados()
    {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};

        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");

        for(int indice = 0; indice < candidatos.length; indice++)
        {
            System.out.println("O candidato de n°" + (indice+1) + " é o " + candidatos[indice]);
        }

        /*System.out.println("forma abreviada de interação for each");
          for(String candidatos: candidatos)
          {
            System.out.println("O candidato selecionado foi " + candidato);
          }


        */
    }

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
