package one.digitalinnovation.gof.singleton;

/**
 * Singleton "Lazy Holder".
 * Implementação mais eficiente e thread-safe do padrão Singleton em Java.
 *
 * Utiliza o carregamento de classes (ClassLoader) para garantir que
 * a instância só seja criada quando o método getInstancia() for chamado,
 * sem necessidade de sincronização explícita.
 *
 * @see <a href="https://stackoverflow.com/a/24018148">Referencia</a>
 */
public class SingletonLazyHolder
{
    // Classe interna estática só é carregada quando for referenciada.
    // Isso garante inicialização "lazy" e segurança em ambientes multithread.
    private static class InstanceHolder
    {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    // Construtor privado impede criação de instâncias externas.
    private SingletonLazyHolder()
    {
        super();
    }

    // Retorna a instância única, inicializada de forma thread-safe.
    public static SingletonLazyHolder getInstancia()
    {
        return InstanceHolder.instancia;
    }
}
