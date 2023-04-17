package models;

import java.util.Date;

public class venda {
    private int id;
    private Date data;
    private int id_cliente;
    private int id_loja;
    private double total;

    // construtor
    public venda(int id, Date data, int id_cliente, int id_loja, double total) {
        this.id = id;
        this.data = data;
        this.id_cliente = id_cliente;
        this.id_loja = id_loja;
        this.total = total;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}