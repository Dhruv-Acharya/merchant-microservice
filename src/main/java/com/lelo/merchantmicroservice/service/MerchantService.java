package com.lelo.merchantmicroservice.service;

import com.lelo.merchantmicroservice.entity.Merchant;

public interface MerchantService {
    public void addRating(String merchanrId, double rating);
    public Merchant findOne(String merchantId);
}
