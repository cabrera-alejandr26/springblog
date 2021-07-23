package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name= "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 125)
    private String title;

    @Column(nullable = false, length = 600)
    private String body;


    public Post() {
    }

    public Post (String title, String body) {
        this.title;
        this.body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}