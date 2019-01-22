package com.lelo.merchantmicroservice.controller;

import com.lelo.merchantmicroservice.dto.MerchantDTO;
import com.lelo.merchantmicroservice.entity.Merchant;
import com.lelo.merchantmicroservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

//    @RequestMapping(value = "/rating/add/{merchantId}", method = RequestMethod.POST)
//    public ResponseEntity<Boolean> addRating(@PathVariable String merchantId, @RequestBody MerchantDTO rating) {
//        merchantService.addRating(merchantId, rating);
//        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
//    }

    @RequestMapping(value = "/rating/get/{merchantId}", method = RequestMethod.GET)
    public ResponseEntity<Merchant> findOne(@PathVariable String merchantId) {
        return new ResponseEntity<Merchant>(merchantService.findOne(merchantId),HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody MerchantDTO merchant) {
        return new ResponseEntity<String>(merchantService.save(merchant).getMerchantId(),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getMerchantsByIds", method = RequestMethod.POST)
    public ResponseEntity<List<Merchant>> getMerchants(@RequestBody List<String> merchants) {
        return new ResponseEntity<List<Merchant>>(merchantService.getMerchants(merchants), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Merchant>> getAll() {
        return new ResponseEntity<List<Merchant>>(merchantService.getAll(), HttpStatus.OK);
    }
}
