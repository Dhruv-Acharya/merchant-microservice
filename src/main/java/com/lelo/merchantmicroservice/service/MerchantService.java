package com.lelo.merchantmicroservice.service;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.entity.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant findOne(String merchantId);
    Merchant save(MerchantDTO merchantDto);
    List<MerchantDTO> getMerchants(List<String> merchants);
    List<Merchant> getAll();
}
