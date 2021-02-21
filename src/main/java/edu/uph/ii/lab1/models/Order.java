package edu.uph.ii.lab1.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_order;

    @NotNull
    @Size(min = 1,max = 2)
    @Column(name = "days") // ilość dni
    private Integer days;
    @NotNull
    @Column(name = "cost") // ilość do zapłacenia
    private Integer cost;
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costume_id")
    private Costume costume;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "day") //dzień zamowienia
    private LocalDate day;

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }


    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Order(){}

    public Order create(@NotNull Integer days,@NotNull Integer cost, User user, Status status, LocalDate day,Costume costume) {

        var order = new Order();
        order.setDays(days);
        order.setCost(cost);
        order.setUser(user);
        order.setStatus(status);
        order.setDay(day);
        order.setCostume(costume);

        return order;


    }
}