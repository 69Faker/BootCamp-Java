package me.thiago.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_feature")
// Entidade mapeada para a tabela "tb_feature"
// Herda os atributos de BaseItem (id, icon, description)
public class Feature extends BaseItem
{

}
