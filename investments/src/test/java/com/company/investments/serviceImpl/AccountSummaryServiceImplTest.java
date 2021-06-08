package com.company.investments.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.company.investments.entity.Users;
import com.company.investments.repository.UserAccountsRepository;
import com.company.investments.repository.UsersRepository;

class AccountSummaryServiceImplTest {

	@Mock
	private UsersRepository usersRepository;
	
	@Mock
	private UserAccountsRepository userAccountsRepository;
	
	@InjectMocks
	private AccountSummaryServiceImpl accountSummaryServiceImpl;
	
	private final Users user=new Users((long) 1,"Aayu","Pandit","asp@gmail.com","A@yush");
	
	@Test
	void userCheckTest() {
		Optional<Users> userr=Optional.of(user);
		when(usersRepository.findById(user.getUserId())).thenReturn(userr);
		assertNotNull(userr);
	}

}
