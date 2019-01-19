package com.lelo.merchantmicroservice.service.impl;

import com.lelo.merchantmicroservice.entity.Merchant;
import com.lelo.merchantmicroservice.repository.MerchantRepository;
import com.lelo.merchantmicroservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public void addRating(String merchantId, double rating) {
        Merchant merchant = this.findOne(merchantId);
        double newRating = merchant.getRating() + rating;
        int newRatingCount = merchant.getRatingCounter() + 1;
        merchant.setRating(newRating / newRatingCount);
    }

    @Override
    public Merchant findOne(String merchantId) {
        return merchantRepository.findOne(merchantId);
    }
}