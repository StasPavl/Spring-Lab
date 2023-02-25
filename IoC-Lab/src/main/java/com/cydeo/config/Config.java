package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {
    @Bean
    public Currency dollar(){
        return new Currency("$","dollar");
    }
    @Bean
    public Current current(){
        return new Current(dollar(),new BigDecimal(100), UUID.randomUUID());
    }
    @Bean
    public Saving saving(){
        return new Saving(dollar(),new BigDecimal(120),UUID.randomUUID());
    }
}
