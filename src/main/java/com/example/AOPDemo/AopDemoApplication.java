package com.example.AOPDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("merchant")
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Autowired
	private MerchantService merchantService;

	@PostMapping("create")
	public Merchant createMerchant(@RequestBody MerchantDTO merchantDTO) {
		return merchantService.createMerchant(merchantDTO.getName(), merchantDTO.getMerchantId());
	}

	@DeleteMapping("delete/{merchantId}")
	public void deleteMerchant(@PathVariable String merchantId) {
		merchantService.deleteMerchant(merchantId);
	}
}
