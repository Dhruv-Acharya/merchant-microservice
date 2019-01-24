package com.lelo.merchantmicroservice.service.impl;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.entity.Merchant;
import com.lelo.merchantmicroservice.exception.MerchantAlreadyExists;
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
    public List<MerchantDTO> getMerchants(List<String> merchantList) {
        List<MerchantDTO> merchants = new ArrayList<>();
        Iterator merchantIterator = merchantList.iterator();
        while (merchantIterator.hasNext()) {
            Merchant merchant = merchantRepository.findOne((String) merchantIterator.next());
            MerchantDTO merchantDTO = new MerchantDTO();
            merchantDTO.setEmailId(merchantDTO.getEmailId());
            merchantDTO.setMerchantId(merchant.getMerchantId());
            merchantDTO.setRating(merchant.getRating());
            merchantDTO.setName(merchant.getName());
            merchants.add(merchantDTO);
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