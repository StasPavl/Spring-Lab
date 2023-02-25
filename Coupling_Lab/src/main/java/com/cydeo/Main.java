package com.cydeo;

import com.cydeo.loose.Balance;
import com.cydeo.loose.BalanceManager;
import com.cydeo.tight.BalanceService;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        CustomerBalance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        GiftCardBalance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);
        DebitCardBalance debitCardBalance = new DebitCardBalance(user,new BigDecimal(100));

        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        /*BalanceService balanceService =
                new BalanceService(customerBalance, giftCardBalance);

        System.out.println(balanceService.checkoutFromCustomerBalance(new BigDecimal(80)));
        System.out.println(balanceService.checkoutFromGiftBalance(new BigDecimal(80)));
*/

        boolean checkout = customerBalance.checkout(customerBalance, new BigDecimal(80));
        System.out.println(checkout);
        System.out.println(debitCardBalance.checkout(debitCardBalance, new BigDecimal(110)));
    }

}
