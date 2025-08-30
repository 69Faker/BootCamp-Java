package me.thiago.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity(name = "tb_account") // Mapeia a classe para a tabela "tb_account"
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Geração automática de IDs (identity: deixa a cargo do banco)
    private Long id;

    @Column(unique = true)
    // Restringe para que o número da conta seja único no banco
    private String number;

    private String agency;

    @Column(precision = 13, scale = 2)
    // Define precisão e escala para valores monetários
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    // Personaliza o nome da coluna e também define precisão/escala
    private BigDecimal limit;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getAgency()
    {
        return agency;
    }

    public void setAgency(String agency)
    {
        this.agency = agency;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }

    public BigDecimal getLimit()
    {
        return limit;
    }

    public void setLimit(BigDecimal limit)
    {
        this.limit = limit;
    }
}
