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

    @RequestMapping(value = "/rating/get/{merchantId}", method = RequestMethod.GET)
    public ResponseEntity<Merchant> findOne(@PathVariable String merchantId) {
        return new ResponseEntity<>(merchantService.findOne(merchantId), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Merchant> save(@RequestBody MerchantDTO merchant) {
        return new ResponseEntity<>(merchantService.save(merchant), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getMerchantsByIds", method = RequestMethod.POST)
    public ResponseEntity<List<MerchantDTO>> getMerchants(@RequestBody List<String> merchants) {
        return new ResponseEntity<>(merchantService.getMerchants(merchants), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Merchant>> getAll() {
        return new ResponseEntity<>(merchantService.getAll(), HttpStatus.OK);
    }
}
