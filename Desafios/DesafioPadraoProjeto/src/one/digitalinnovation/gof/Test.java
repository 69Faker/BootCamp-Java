package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.Comportamento;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;

public class Test
{
    public static void main(String[] args)
    {
        // ---------- Singleton ----------
        // Testando os três tipos de Singleton implementados (Lazy, Eager e LazyHolder).
        // A impressão dos objetos mostra que a instância é a mesma em todas as chamadas.

        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);

        // ---------- Strategy ----------
        // Padrão Strategy: permite alterar dinamicamente o comportamento do objeto Robo.
        // Aqui são testados três tipos de movimento: normal, defensivo e agressivo.

        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();

        robo.setComportamento(defensivo);
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();

        // ---------- Facade ----------
        // Padrão Facade: simplifica chamadas para subsistemas complexos.
        // O cliente do código só precisa chamar o método migrarCliente,
        // sem lidar diretamente com CRM ou API de CEP.

        Facade facade = new Facade();
        facade.migrarCliente("Venilton", "14801788");
    }
}
