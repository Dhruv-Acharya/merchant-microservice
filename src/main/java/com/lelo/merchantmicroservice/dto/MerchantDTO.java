package com.lelo.merchantmicroservice.dto;

public class MerchantDTO {
    private String merchantId;
    private String name;
    private String emailId;

    public MerchantDTO() {
    }

    public MerchantDTO(String merchantId, String name, String emailId) {
        this.merchantId = merchantId;
        this.name = name;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
