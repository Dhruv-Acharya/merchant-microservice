package com.lelo.merchantmicroservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = Merchant.TABLE_NAME)
public class Merchant {
    public static final String TABLE_NAME = "MERCHANT";
    private static final String ID_COLUMN = "ID";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = Merchant.ID_COLUMN)
    private String merchantId;
    private String name;
    private double rating;
    private double ratingCounter;
    private String emailId;

    public Merchant() {
    }

    public Merchant(String merchantId, String name, double rating, double ratingCounter, String emailId) {
        this.merchantId = merchantId;
        this.name = name;
        this.rating = rating;
        this.ratingCounter = ratingCounter;
        this.emailId = emailId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(double ratingCounter) {
        this.ratingCounter = ratingCounter;
    }
}
