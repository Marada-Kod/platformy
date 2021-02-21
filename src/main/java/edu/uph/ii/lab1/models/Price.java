package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_price;
    @NotNull
    @Column(name = "deposit") //kaucja
    private Integer deposit;
    @NotNull
    @Column(name = "cost") //koszt
    private Integer cost;
    @NotNull
    @Column(name = "name_price") //rodzaj / typ
    private String name_price;



    public long getId_price() {
        return id_price;
    }

    public void setId_price(long id_price) {
        this.id_price = id_price;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getName_price() {
        return name_price;
    }

    public void setName_price(String name_price) {
        this.name_price = name_price;
    }
    public Price(){
    }
    public Price(@NotNull Integer deposit,@NotNull Integer cost,@NotNull String name_price) {
        this.deposit= deposit;
        this.cost= cost;
        this.name_price=name_price;
    }
}
