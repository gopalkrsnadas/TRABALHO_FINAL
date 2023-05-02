package models;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;


@Entity
public class CarrinhoDeCompras {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private int id_cliente;
    private List<Produto> Produtos;
    private List<Integer> quantidade;

    // construtor
    public CarrinhoDeCompras(Integer id, Integer id_cliente, List<Produto> Produtos, List<Integer> quantidade) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.Produtos = Produtos;
        this.quantidade = quantidade;
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
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
