package com.example.AOPDemo;

import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    public Merchant createMerchant(String name, String merchantId) {
        return new Merchant(name, merchantId);
    }

    public void deleteMerchant(String merchantId) {
        if(merchantId.length() < 5) throw  new RuntimeException("Invalid merchant Id");
        System.out.println("Deleted");
    }
}
