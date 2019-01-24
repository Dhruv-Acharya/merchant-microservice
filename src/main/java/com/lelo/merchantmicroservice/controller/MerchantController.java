package com.lelo.merchantmicroservice.controller;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.entity.Merchant;
import com.lelo.merchantmicroservice.exception.MerchantAlreadyExists;
import com.lelo.merchantmicroservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "/rating/get/{merchantId}", method = RequestMethod.GET)
    public ResponseEntity<Merchant> findOne(@PathVariable String merchantId) {
        return new ResponseEntity<>(merchantService.findOne(merchantId), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody MerchantDTO merchant) {
        Merchant merchantDTO = merchantService.findOne(merchant.getMerchantId());
        if(merchantDTO==null){
            return new ResponseEntity<>(merchantService.save(merchant).getMerchantId(), HttpStatus.CREATED);
        }
        else if(merchantDTO.getName()==null){
            throw new MerchantAlreadyExists();
        }
        else{
            throw new MerchantAlreadyExists();
        }

    }
}
