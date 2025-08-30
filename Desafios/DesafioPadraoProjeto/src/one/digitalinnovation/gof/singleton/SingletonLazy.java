package one.digitalinnovation.gof.singleton;

/**
 * Singleton "preguiçoso".
 * A instância só é criada quando for realmente necessária (lazy initialization).
 */
public class SingletonLazy
{
    // Instância só é inicializada no momento da primeira chamada ao getInstancia()
    private static SingletonLazy instancia;

    // Construtor privado para evitar criação de objetos fora da classe
    private SingletonLazy()
    {
        super();
    }

    // Metodo acessor que cria a instância apenas quando necessário.
    // Obs: não é thread-safe, em cenários concorrentes pode gerar múltiplas instâncias.
    public static SingletonLazy getInstancia()
    {
        if (instancia == null)
        {
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
