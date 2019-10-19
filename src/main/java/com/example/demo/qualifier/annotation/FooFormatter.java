package com.example.demo.qualifier.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fooFormatter")
@Primary
public class FooFormatter implements Formatter {

	@Override
	public String format() {
		// TODO Auto-generated method stub
		return "FooFormatter";
	}

	

}
