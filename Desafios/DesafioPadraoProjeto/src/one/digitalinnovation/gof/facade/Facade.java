package one.digitalinnovation.gof.facade;

import subsistema1.crm.CrmService;
import subsistema2.cep.CepApi;

public class Facade
{
    // A fachada simplifica a interação entre diferentes subsistemas (CRM e CEP)
    // O cliente do código não precisa conhecer a lógica interna de cada subsistema.
    public void migrarCliente(String nome, String cep)
    {
        // Singleton: recupera instância única de CepApi
        // Esse padrão garante que só exista um objeto centralizado para consultar CEP.
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        // O metodo encapsula a chamada ao subsistema CRM, reduzindo o acoplamento.
        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}