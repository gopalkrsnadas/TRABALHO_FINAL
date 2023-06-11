package org.example.models;


import org.springframework.data.annotation.Id;

import javax.persistence.*;


//@Entity = Define que a classe é um entidade/model
@Entity
public class Cliente {

    //@Id = Define que o atributo é um id
    //@GeneratedValue = Define que a geração do valor do id da entidade será gerenciada pelo provedor de persistência (JPA)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    @ManyToOne
    @JoinColumn(name="carrinhoDeCompras_id", nullable=false)
    private Cliente cliente;



    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
