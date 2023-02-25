package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Currency {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }
}
