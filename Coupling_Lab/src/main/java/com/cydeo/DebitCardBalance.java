package com.cydeo;

import com.cydeo.loose.BalanceManager;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
public class DebitCardBalance extends BalanceManager {

    private UUID userId;
    private BigDecimal amount;

    public DebitCardBalance(UUID userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }
    public BigDecimal addBalance(BigDecimal amount){
        setAmount(this.amount.add(amount));
        return this.amount;
    }
}
