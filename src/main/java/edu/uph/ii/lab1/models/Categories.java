package edu.uph.ii.lab1.models;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotNull
     @Column(name = "name_costume", length = 65)
    private String name_costume;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_costume() {
        return name_costume;
    }

    public Categories(){

    }
    public Categories(@NotNull String name_costume) {
        this.name_costume = name_costume;}

    public void setName_costume(String name_costume) {
        this.name_costume = name_costume;
    }

}



