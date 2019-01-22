package com.lelo.merchantmicroservice.service.impl;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.dto.MerchantDTOList;
import com.lelo.merchantmicroservice.entity.Merchant;
import com.lelo.merchantmicroservice.repository.MerchantRepository;
import com.lelo.merchantmicroservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public List<Merchant> getMerchants(List<String> merchantList) {
        List<Merchant> merchants = new ArrayList<>();
        Iterator merchantIterator = merchantList.iterator();
        while (merchantIterator.hasNext()) {
            Merchant merchant = merchantRepository.findOne((String) merchantIterator.next());
            merchants.add(merchant);
        }
        return merchants;
    }

    @Override
    public List<Merchant> getAll() {
        List<Merchant> merchantList = new ArrayList<>();
        Iterable<Merchant> merchants = merchantRepository.findAll();
        Iterator merchantIterator = merchants.iterator();
        while (merchantIterator.hasNext()) {
            Merchant merchant = (Merchant) merchantIterator.next();
            merchantList.add(merchant);
        }
        return merchantList;
    }
}