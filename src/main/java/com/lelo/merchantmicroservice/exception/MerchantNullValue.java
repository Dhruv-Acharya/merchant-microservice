package com.lelo.merchantmicroservice.exception;/* Made by: mehtakaran9 */


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Null Parameter Passed")
public class MerchantNullValue extends RuntimeException{

}
