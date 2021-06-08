package com.company.investments.dto;

import java.util.List;

public class InvestmentAccountsResponseDto {
	
	private List<AccountsDto> accountsList;
	
	
	public List<AccountsDto> getAccountsList() {
		return accountsList;
	}
	public void setAccountsList(List<AccountsDto> accountsList) {
		this.accountsList = accountsList;
	}

}
