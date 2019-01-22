package com.lelo.merchantmicroservice.service;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.dto.MerchantDTOList;
import com.lelo.merchantmicroservice.entity.Merchant;

import java.util.List;

public interface MerchantService {
//    public void addRating(String merchanrId, MerchantDTO rating);
    public Merchant findOne(String merchantId);
    public Merchant save(MerchantDTO merchantDto);
    public List<Merchant> getMerchants(List<String> merchants);
}
