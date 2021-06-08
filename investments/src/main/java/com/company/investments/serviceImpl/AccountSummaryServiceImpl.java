package com.company.investments.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.investments.dto.AccountsDto;
import com.company.investments.entity.UserAccounts;
import com.company.investments.entity.Users;
import com.company.investments.exception.UserAccountNotFoundException;
import com.company.investments.exception.UserNotFoundException;
import com.company.investments.repository.UserAccountsRepository;
import com.company.investments.repository.UsersRepository;
import com.company.investments.service.AccountSummaryService;
/**
 * author aayush.pandit
 */
@Service
public class AccountSummaryServiceImpl implements AccountSummaryService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserAccountsRepository userAccountsRepository;
	
	/**
	 * logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AccountSummaryServiceImpl.class);


    @Override
	public List<AccountsDto> getInvestmentAccounts(Long userId) {
		
    	logger.info("Inside getInvestmentAccounts() ServiceImpl Method.");
		Optional<Users> user=usersRepository.findById(userId);
		
		if(!user.isPresent()) {
			logger.info("User Not Found. For the User Id:"+userId);
			throw new UserNotFoundException("User Not Found. For the User Id:"+userId);
		}
		
		Users loguser=user.get();
		List<UserAccounts> list=userAccountsRepository.findByUser(loguser);
		
		if(list.size()<1) {
			logger.info("User Account Not Found.For User First Name :"+loguser.getFirstName());
			throw new UserAccountNotFoundException("User Account Not Found.For User First Name :"+loguser.getFirstName());
		}
		
		List<AccountsDto> accountlist=new ArrayList<>();
		list.stream().forEach(t ->{
		AccountsDto account1=new AccountsDto();
		BeanUtils.copyProperties(t, account1);
		accountlist.add(account1);}
		);
		
		logger.info("Exiting getInvestmentAccounts() ServiceImpl Method.");
		return accountlist;
		
	}

}
