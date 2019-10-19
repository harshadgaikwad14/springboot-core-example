package com.example.demo.qualifier.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormatterService {
      
    @Autowired
   // @Qualifier("barFormatter")
    private Formatter formatter;
    
    public void getFormatter()
    {
    	System.out.println(formatter.format());
    }
}