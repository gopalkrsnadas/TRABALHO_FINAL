package org.example.models;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;


@Entity
public class CarrinhoDeCompras {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private int idcliente;
    private List<Produto> Produtos;
    private List<Integer> quantidade;

    @OneToMany(mappedBy = "carrinhoDeCompras")
    private List<Produto> produtos;



    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer id_cliente) {
        this.idcliente = id_cliente;
    }

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> Produtos) {
        this.Produtos = Produtos;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(List<Integer> quantidade) {
        this.quantidade = quantidade;
    }
}

