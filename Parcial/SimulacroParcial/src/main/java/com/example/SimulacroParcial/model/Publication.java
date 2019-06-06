package com.example.SimulacroParcial.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Publication {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private String pictureFilePath;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user_id")
    private List<User> likedUserList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "comment_id")
    private List<Comment> commentList;


    public Publication(String title, String description, String pictureFilePath, Date date, User author, List<User> likedUserList, List<Comment> commentList) {
        this.title = title;
        this.description = description;
        this.pictureFilePath = pictureFilePath;
        this.date = date;
        this.author = author;
        this.likedUserList = likedUserList;
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPictureFilePath() {
        return pictureFilePath;
    }
    public void setPictureFilePath(String pictureFilePath) {
        this.pictureFilePath = pictureFilePath;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public List<User> getLikedUserList() {
        return likedUserList;
    }
    public void setLikedUserList(List<User> likedUserList) {
        this.likedUserList = likedUserList;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
