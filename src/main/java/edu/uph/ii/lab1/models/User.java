package edu.uph.ii.lab1.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @NotNull
    @Size(min = 3,max = 15)
    @Column(name = "first_name")
    private String first_name;
    @NotNull
    @Size(min = 3,max = 15)
    @Column(name = "last_name")
    private String last_name;
    @NotNull
    @Size(min = 4,max = 40)
    @Column(name = "username")
    private String username;
    @NotNull
    @Size(min = 3,max = 15)
    @Column(name = "address")
    private String address;
    @NotNull
    @Size(min = 6,max = 20)
    @Column(name = "postcode")
    private String postcode;
    @Email
    @Column(name = "email")
    private String email;
    @NotNull
    @NotEmpty
    @Column(name = "password", length = 64)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {

    }

    public User(@NotNull @Size(min = 3, max = 15) String first_name, @NotNull @Size(min = 3,max = 15) String last_name,@Size(min = 4,max = 40) String username, @NotNull @Size(min = 3,max = 15) String address, @NotNull @Size(min = 6,max = 20) String postcode, @Email String email, @NotNull @Size(min = 5, max = 15) String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        this.password = password;
    }
}
