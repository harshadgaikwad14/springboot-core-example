package com.example.demo.qualifier.annotation;

import org.springframework.stereotype.Component;

@Component("barFormatter")
public class BarFormatter implements Formatter {

	@Override
	public String format() {
		// TODO Auto-generated method stub
		return "barFormatter";
	}

}