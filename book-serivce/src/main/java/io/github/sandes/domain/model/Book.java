package io.github.sandes.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String author;
    private String title;
    private Date launchDate;
    private Double price;
    private String currency;

    public Book(Long id, String author, String title, Date lauchDate, Double price, String currency) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.launchDate = lauchDate;
        this.price = price;
        this.currency = currency;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
