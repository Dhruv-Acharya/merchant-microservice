package com.lelo.merchantmicroservice.exception;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Already Exists")
public class MerchantAlreadyExists extends RuntimeException{
}
