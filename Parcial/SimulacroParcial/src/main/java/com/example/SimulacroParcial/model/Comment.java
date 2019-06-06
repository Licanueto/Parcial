package com.example.SimulacroParcial.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication_id", referencedColumnName = "id")
    private Publication publication;


    public Comment(String description, String date, User owner, Publication publication) {
        this.description = description;
        this.date = date;
        this.owner = owner;
        this.publication = publication;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public Publication getPublication() {
        return publication;
    }
    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
