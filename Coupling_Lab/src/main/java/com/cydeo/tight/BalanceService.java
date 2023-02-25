package com.cydeo.tight;

import com.cydeo.CustomerBalance;
import com.cydeo.GiftCardBalance;

import java.math.BigDecimal;

public class BalanceService {
    CustomerBalance customerBalance;
    GiftCardBalance giftCardBalance;

    public BalanceService(CustomerBalance customerBalance, GiftCardBalance giftCardBalance) {
        this.customerBalance = customerBalance;
        this.giftCardBalance = giftCardBalance;
    }

    public boolean checkoutFromCustomerBalance(BigDecimal checkoutAmount){
        BigDecimal customerBalanceAmount = customerBalance.getAmount();

        return customerBalanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
    public boolean checkoutFromGiftBalance(BigDecimal checkoutAmount){
        BigDecimal giftCardBalanceAmount = giftCardBalance.getAmount();

        return giftCardBalanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}
