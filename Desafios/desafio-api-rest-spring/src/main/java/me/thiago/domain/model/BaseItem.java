package me.thiago.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
// Classe base mapeada, mas não vira tabela diretamente.
// Suas propriedades são herdadas pelas entidades filhas.
public abstract class BaseItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador único gerado automaticamente pelo banco.
    private Long id;

    private String icon;

    private String description;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
