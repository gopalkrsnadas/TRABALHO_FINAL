package models;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Date data;
    private Integer id_cliente;
    private Integer id_loja;
    private double total;

    // construtor
    public Venda(Integer id, Date data, int id_cliente, Integer id_loja, double total) {
        this.id = id;
        this.data = data;
        this.id_cliente = id_cliente;
        this.id_loja = id_loja;
        this.total = total;
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_loja() {
        return id_loja;
    }

    public void setId_loja(Integer id_loja) {
        this.id_loja = id_loja;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}