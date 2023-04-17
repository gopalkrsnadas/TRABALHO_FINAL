package models;
import java.util.List;

public class carrinhoDeCompras {
    private int id;
    private int id_cliente;
    private List<produto> produtos;
    private List<Integer> quantidade;

    // construtor
    public carrinhoDeCompras(int id, int id_cliente, List<produto> produtos, List<Integer> quantidade) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.produtos = produtos;
        this.quantidade = quantidade;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<produto> produtos) {
        this.produtos = produtos;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(List<Integer> quantidade) {
        this.quantidade = quantidade;
    }
}

