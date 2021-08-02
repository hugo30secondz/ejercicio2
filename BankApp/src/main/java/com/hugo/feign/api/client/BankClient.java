package com.hugo.feign.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hugo.feign.api.dto.BankResponse;

//@FeignClient(url="http://localhost:8080",name="BANK-CLIENT")
public interface BankClient {
	//@GetMapping("/myBankList")
	public List<BankResponse> getBanks();
}
