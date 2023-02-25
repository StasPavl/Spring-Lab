package com.cydeo.loose;

import com.cydeo.CustomerBalance;
import com.cydeo.GiftCardBalance;

import java.math.BigDecimal;

public class BalanceManager extends Balance{



    public boolean checkout(Balance balance, BigDecimal amount){
        return balance.getAmount().subtract(amount).compareTo(BigDecimal.ZERO) > 0;

    }
}

