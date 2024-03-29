package com.lelo.merchantmicroservice.repository;

import com.lelo.merchantmicroservice.entity.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, String> {
}
