package com.company.investments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.company.investments.dto.AccountsDto;
import com.company.investments.dto.InvestmentAccountsResponseDto;
import com.company.investments.service.AccountSummaryService;

/**
 * author aayush.pandit
 */
@RestController
@RequestMapping("/users")
public class AccountSummaryController {
	
	@Autowired
	private AccountSummaryService accountSummaryService;
	
	/**
	 * logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AccountSummaryController.class);

	@GetMapping("/{userId}/accounts")
	public ResponseEntity<InvestmentAccountsResponseDto> getInvestmentAccounts(@PathVariable("userId")Long userId){
		
		logger.info("Inside getInvestmentAccounts() Method.");
		InvestmentAccountsResponseDto result=new InvestmentAccountsResponseDto();
		List<AccountsDto> list=accountSummaryService.getInvestmentAccounts(userId);
		result.setAccountsList(list);
		logger.info("Exiting getInvestmentAccounts() Method.");
		return new ResponseEntity<InvestmentAccountsResponseDto>(result, HttpStatus.OK);
		
	}
}
