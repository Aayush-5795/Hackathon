package com.company.investments.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.company.investments.controller.AccountSummaryController;
import com.company.investments.dto.AccountsDto;
import com.company.investments.dto.InvestmentAccountsResponseDto;
import com.company.investments.service.AccountSummaryService;

@ExtendWith(MockitoExtension.class)
public class AccountSummaryControllerTest {
	
	@Mock
	private AccountSummaryService accountSummaryService;
	
	@InjectMocks
	private AccountSummaryController accountSummaryController;
	
	static Long userId=(long) 1;
	
	static List<AccountsDto> list;
	
	@BeforeAll
	public static void setUp() {
		list=new ArrayList<>();
		AccountsDto account1=new AccountsDto();
		account1.setAccountNumber(21);
		account1.setBalance(10000.00);
		list.add(account1);
	}
	
	@Test
	public void getInvestmentAccountsTest() {
		
		InvestmentAccountsResponseDto result=new InvestmentAccountsResponseDto();
		
		when(accountSummaryService.getInvestmentAccounts(userId)).thenReturn(list);
		
		result.setAccountsList(list);
		
		ResponseEntity<InvestmentAccountsResponseDto> savdb=accountSummaryController.getInvestmentAccounts(userId);
		
		assertEquals(list.size(), savdb.getBody().getAccountsList().size());
	}

}
