package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @NotNull
    @Size(max = 30,min = 2)
    @Column(name = "name_gender")

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Gender(){
    }

    public Gender(long id,@NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
