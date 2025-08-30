package me.thiago.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_news")
// Entidade mapeada para a tabela "tb_news"
// Herda os atributos de BaseItem (id, icon, description)
public class News extends BaseItem
{

}
