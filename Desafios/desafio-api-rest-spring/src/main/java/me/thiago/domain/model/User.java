package me.thiago.domain.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "tb_user")
// Entidade mapeada para a tabela "tb_user"
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador único gerado automaticamente pelo banco
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    // Relacionamento 1:1 com Account
    // Cascade.ALL garante que operações em User afetem Account
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    // Relacionamento 1:1 com Card
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // Relacionamento 1:N com Feature
    // EAGER: carrega os dados imediatamente junto com User
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // Relacionamento 1:N com News
    private List<News> news;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    public List<Feature> getFeatures()
    {
        return features;
    }

    public void setFeatures(List<Feature> features)
    {
        this.features = features;
    }

    public List<News> getNews()
    {
        return news;
    }

    public void setNews(List<News> news)
    {
        this.news = news;
    }
}
