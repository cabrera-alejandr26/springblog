package com.codeup.springblog.models;

import jdk.jfr.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 140)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToOne
    private AdImage adImage;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ads_categories",
            joinColumns = {@JoinColumn(name="ad_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

    public Ad(){}

    public Ad(long id, String title, String description, AdImage adImage, User user, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adImage = adImage;
        this.user = user;
        this.categories = categories;
    }
