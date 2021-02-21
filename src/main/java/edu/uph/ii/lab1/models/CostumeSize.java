package edu.uph.ii.lab1.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Size")
public class CostumeSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_size;
    @NotEmpty
    @javax.validation.constraints.Size(min = 1, max = 50)
    @Column(name = "name_size")
    private String name_size;

    public long getId_size() {
        return id_size;
    }

    public void setId_size(long id_size) {
        this.id_size = id_size;
    }

    public String getName_size() {
        return name_size;
    }

    public void setName_size(String name_size) {
        this.name_size = name_size;
    }

    public CostumeSize(long id_size, @NotEmpty String name_size) {
        this.id_size = id_size;
        this.name_size = name_size;
    }

    public CostumeSize() {
    }
}
