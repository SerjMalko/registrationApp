package com.sands.regtest.data.req;

import com.sands.regtest.util.validator.NotNullWithDepends;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by mass on 11.08.2016.
 */
public class EmailValidationRequest {
    private String secureCode;

    public EmailValidationRequest() {
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    @Override
    public String toString() {
        return "EmailValidationRequest{" +
                "secureCode='" + secureCode + '\'' +
                '}';
    }
}
