package com.lelo.merchantmicroservice.service.impl;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.entity.Merchant;
import com.lelo.merchantmicroservice.repository.MerchantRepository;
import com.lelo.merchantmicroservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

//    @Override
//    @Transactional(readOnly = false)
//    public void addRating(String merchantId, MerchantDTO merchantDTO) {
//        Merchant merchant = this.findOne(merchantId);
//        double rating = merchantDTO
//        double newRating = merchant.getRating() + rating;
//        double newRatingCount = merchant.getRatingCounter() + 1;
//        merchant.setRatingCounter(newRatingCount);
//        System.out.println(newRating + " " + newRatingCount + " " + newRating / newRatingCount);
//        merchant.setRating(newRating / newRatingCount);
//    }

    @Override
    public Merchant findOne(String merchantId) {
        return merchantRepository.findOne(merchantId);
    }

    @Override
    @Transactional(readOnly = false)
    public Merchant save(MerchantDTO merchantDto) {
        Merchant merchant = new Merchant();
        merchant.setEmailId(merchantDto.getEmailId());
        merchant.setName(merchantDto.getName());
        return merchantRepository.save(merchant);
    }
}