package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Status")
public class Status {  //statu zamówienia

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_status;

    @NotNull
    @Column(name = "name_status", length = 65)
    private String name_status;



    public long getId_status() {
        return id_status;
    }

    public void setId_status(long id_status) {
        this.id_status = id_status;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    public Status(long id_status,@NotNull String name_status) {
        this.id_status = id_status;
        this.name_status = name_status;
    }

    public Status() {
    }
}
