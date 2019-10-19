package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.qualifier.annotation.FormatterService;
import com.example.demo.scope.annotation.AccountService;
import com.example.demo.scope.annotation.BalanceService;

@SpringBootApplication
public class SpringbootCoreExampleApplication {
	
	

	public static void main(String[] args) {
		final ApplicationContext context = SpringApplication.run(SpringbootCoreExampleApplication.class, args);
		
		
		
		/* Bean Scope Scenario
		 * If parent(2instance) and child(2instance) both having prototype scope then create individual instance of parent(2instance) and child(2instance).
		 * If parent(2instance) is singleton and child(2instance) is prototype then create individual instance of parent(2instance) and child(2instance).
		 * If parent(2instance) is singleton and child(2instance) is singleton then create individual instance of parent(2instance) and child(1instance).
		 * If parent(2instance) is prototype and child(2instance) is singleton then create individual instance of parent(2instance) and child(1instance).
		 */
	
		
		
		final BalanceService balanceService1 = context.getBean(BalanceService.class);
		balanceService1.setBalance(1);
		final BalanceService balanceService2 = context.getBean(BalanceService.class);
		balanceService2.setBalance(2);

		final AccountService service1 = context.getBean(AccountService.class);
		service1.setAccountHolder("service1");
		service1.setBalanceService(balanceService1);
		System.out.println(service1);

		final AccountService service2 = context.getBean(AccountService.class);
		service2.setAccountHolder("service2");
		service2.setBalanceService(balanceService2);
		System.out.println(service2);
		
		//*************************************************
		
		/*
		 * By using the @Qualifier annotation, we can eliminate the issue of which bean needs to be injected.
		 * Let's revisit our previous example and see how we solve the problem by including 
		 * the @Qualifier annotation to indicate which bean we want to use
		 * 
		 * We need to take into consideration that the qualifier name to be used is the one declared in the @Component annotation.
		 * Note that we could've also used the @Qualifier annotation on the Formatter implementing classes, instead of specifying the names in their @Component annotations, 
		 * to obtain the same effect
		 * 
		 * There's another annotation called @Primary that we can use to decide which bean to inject when ambiguity is present regarding dependency injection.
		 * This annotation defines a preference when multiple beans of the same type are present. 
		 * The bean associated with the @Primary annotation will be used unless otherwise indicated.
		 */
		final FormatterService formatterService = context.getBean(FormatterService.class); 
		formatterService.getFormatter();
		

	}

}
