package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {  //statu zamówienia

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name_status", length = 65)
    private String name_status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    public Status(long id_status,@NotNull String name_status) {
        this.id = id_status;
        this.name_status = name_status;
    }

    public Status() {
    }
}
