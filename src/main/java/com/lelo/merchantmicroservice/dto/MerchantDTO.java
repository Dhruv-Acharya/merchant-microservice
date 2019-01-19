package com.lelo.merchantmicroservice.dto;

public class MerchantDTO {
    private String merchantId;
    private String name;
    private double rating;
    private String emailId;

    public MerchantDTO() {
    }

    public MerchantDTO(String merchantId, String name, double rating, String emailId) {
        this.merchantId = merchantId;
        this.name = name;
        this.rating = rating;
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
}
