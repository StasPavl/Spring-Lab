package com.cydeo;

import com.cydeo.loose.Balance;
import com.cydeo.loose.BalanceManager;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

@Getter
@Setter
public class GiftCardBalance extends BalanceManager {
    private UUID userId;
    private BigDecimal amount;

    public GiftCardBalance(UUID userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public BigDecimal addBalance(BigDecimal amount) {
        BigDecimal bonusAmount =
                amount.multiply(BigDecimal.TEN)
                        .divide(new BigDecimal(100)
                                , MathContext.DECIMAL64);

        setAmount(this.amount.add(amount).add(bonusAmount));
        return this.amount;
    }
}
