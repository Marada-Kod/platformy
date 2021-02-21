package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "CostumeType")
public class CostumeType {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotNull
    @Column(name = "name", length = 65)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CostumeType(){

        
    }
    public CostumeType(Integer id,@NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
