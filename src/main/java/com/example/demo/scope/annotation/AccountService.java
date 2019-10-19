package com.example.demo.scope.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccountService {

	private String accountHolder;
	@Autowired
	private BalanceService balanceService;

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public BalanceService getBalanceService() {
		return balanceService;
	}

	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}

	@Override
	public String toString() {
		return "AccountService [accountHolder=" + accountHolder + ", balanceService=" + balanceService + "]";
	}

}