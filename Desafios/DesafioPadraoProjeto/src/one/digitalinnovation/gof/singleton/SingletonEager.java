package one.digitalinnovation.gof.singleton;

/**
 * Singleton "apressado".
 * Esse padrão cria a instância imediatamente quando a classe é carregada.
 * Não espera ser chamado, diferente do "lazy".
 */
public class SingletonEager
{
    // A instância é criada no momento da carga da classe (eager).
    // Garantia de thread safety sem precisar de sincronização explícita.
    private static SingletonEager instancia = new SingletonEager();

    // Construtor privado impede criação de instâncias externas,
    // garantindo que só exista um objeto SingletonEager.
    private SingletonEager()
    {
        super();
    }

    // Metodo público para retornar a instância única da classe.
    public static SingletonEager getInstancia()
    {
        return instancia;
    }
}