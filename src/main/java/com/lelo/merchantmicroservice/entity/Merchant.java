package com.lelo.merchantmicroservice.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotNull
    @Pattern(regexp = "^[A-Za-z]*$", message = "Name must be alphabetical")
    private String name;
    private double rating;
    private double ratingCounter;
    @NotNull
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid Email ID")
    private String emailId;
    public Merchant() {
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
