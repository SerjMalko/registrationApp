package com.sands.regtest.data.req;

import com.sands.regtest.util.validator.NotNullWithDepends;

import javax.validation.constraints.*;

/**
 * Created by mass on 11.08.2016.
 */
@NotNullWithDepends.List(value = {
        @NotNullWithDepends(
                targetFieldName = "landlinePhoneNumber",
                dependentFieldName = "mobilePhoneNumber",
                message="There must be either a landline or a mobile phone number provided, or both.\n"),
})
public class RegistrationRequest {
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;
    private String password;
    private String email;
    private String landlinePhoneNumber;
    private String mobilePhoneNumber;

    public RegistrationRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public void setLandlinePhoneNumber(String landlinePhoneNumber) {
        this.landlinePhoneNumber = landlinePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", landlinePhoneNumber='" + landlinePhoneNumber + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                '}';
    }
}
