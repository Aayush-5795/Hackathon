package com.company.investments.service;

import java.util.List;

import com.company.investments.dto.AccountsDto;

public interface AccountSummaryService {

	List<AccountsDto> getInvestmentAccounts(Long userId);

}
