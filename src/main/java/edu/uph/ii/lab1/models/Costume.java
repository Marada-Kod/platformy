package edu.uph.ii.lab1.models;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "Costume")
public class Costume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @javax.validation.constraints.Size(min = 5,max = 15)
    @Column(name = "name")
    private String name;
    @NotNull
    @javax.validation.constraints.Size(min = 3,max = 255)
    @Column(name = "text")
    private String text;


    @NotNull
    @Column(name = "pieces") //ilość
    private Integer pieces;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cost_id")
    private Price price;


    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private CostumeType type;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private CostumeSize costumeSize;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    private Categories categories;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public CostumeType getType() {
        return type;
    }

    public void setType(CostumeType type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CostumeSize getSize() {
        return costumeSize;
    }

    public void setSize(CostumeSize size) {
        this.costumeSize = size;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Costume() {
    }

    public static Costume create(@NotNull @javax.validation.constraints.Size(min = 5,max = 15) String name, @NotNull @javax.validation.constraints.Size(min = 3,max = 255) String text, @NotNull Integer pieces, CostumeType costumeType, Gender gender, Price price, CostumeSize size, Categories categories) {

        var costium = new Costume();
        costium.setName(name);
        costium.setText(text);
        costium.setPieces(pieces);
        costium.setType(costumeType);
        costium.setGender(gender);
        costium.setPrice(price);
        costium.setSize(size);
        costium.setCategories(categories);


        return costium;

    }
}
