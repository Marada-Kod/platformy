package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "role", schema = "public")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "role_name", length = 65)
    private String roleName;

    public Role() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
