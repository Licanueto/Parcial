package com.example.SimulacroParcial.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private String browser;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Publication> publicationList;

    // Esto es necesario? no creo pero lo agrego para ver si logro que maven no me tire error al mapear..
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Comment> commentList;


    public User(String name, String surname, String browser, List<Publication> publicationList) {
        this.name = name;
        this.surname = surname;
        this.browser = browser;
        this.publicationList = publicationList;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getBrowser() {
        return browser;
    }
    public void setBrowser(String browser) {
        this.browser = browser;
    }
    public List<Publication> getPublicationList() {
        return publicationList;
    }
    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }
}
