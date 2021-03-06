package com.codeup.springblog.models;

import javax.persistence.*;

    @Entity
    @Table(name="ad_images")
    public class AdImage {
        @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private String path;

        @OneToOne
        private Ad ad;

        public AdImage() {



        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Ad getAd() {
            return ad;
        }

        public void setAd(Ad ad) {
            this.ad = ad;
        }
    }


