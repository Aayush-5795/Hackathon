package com.company.investments.serviceImpl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.company.investments.dto.AccountsDto;
import com.company.investments.entity.UserAccounts;
import com.company.investments.entity.Users;
import com.company.investments.exception.UserNotFoundException;
import com.company.investments.repository.UserAccountsRepository;
import com.company.investments.repository.UsersRepository;
import com.company.investments.serviceImpl.AccountSummaryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountSummaryServiceImplTest {
	
	@Mock
	private UsersRepository usersRepository;
	
	@Mock
	private UserAccountsRepository userAccountsRepository;
	
	@InjectMocks
	private AccountSummaryServiceImpl accountSummaryServiceImpl;
	
	static Long userId=(long) 1;
	
	static List<UserAccounts> list;
	
	@BeforeAll
	public static void setUp() {
		list=new ArrayList<>();
		UserAccounts account1=new UserAccounts();
		account1.setAccountNumber(21);
		account1.setBalance(10000.00);
		list.add(account1);
	}
	
	public static List<AccountsDto> getListofAccounts(){
		List<AccountsDto> dbList=new ArrayList<>();
		AccountsDto acount=new AccountsDto();
		acount.setAccountNumber(21);
		acount.setBalance(10000.00);
		AccountsDto acount2=new AccountsDto();
		acount2.setAccountNumber(23);
		acount2.setBalance(20000.00);
		dbList.add(acount);
		dbList.add(acount2);
		return dbList;
	}
	
	
	@Test
	public void getInvestmentAccountsTest() {
		
		Users user=new Users();
		user.setUserId((long) 1);
		user.setFirstName("abc");
		
		Optional<Users> users=Optional.of(user);
		
		when(usersRepository.findById(userId)).thenReturn(users);
		
		when(userAccountsRepository.findByUser(user)).thenReturn(list);
		
		List<AccountsDto> dbList2=accountSummaryServiceImpl.getInvestmentAccounts(userId);
		
		list.stream().forEach(t ->{
			AccountsDto account1=new AccountsDto();
			BeanUtils.copyProperties(t, account1);
			dbList2.add(account1);}
			);
		
		assertEquals(AccountSummaryServiceImplTest.getListofAccounts().size(), dbList2.size());
	}
	
	@Test
	@DisplayName("Check User :Negative scenario")
	public void checkUserTest() {
		
		when(usersRepository.findById(userId)).thenReturn(Optional.ofNullable(null));
		
		assertThrows(UserNotFoundException.class, ()-> accountSummaryServiceImpl.getInvestmentAccounts(userId));
	}
	
}
