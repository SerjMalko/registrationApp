package com.sands.regtest.entity;

import javax.persistence.*;

/**
 * Created by mass on 13.08.2016.
 */
@Entity
@Table(name = "client_info")
public class ClientInfoEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Boolean emailValidation;
    private String landlinePhoneNumber;
    private String mobilePhoneNumber;

    public ClientInfoEntity() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "emailValidation", nullable = true, insertable = true, updatable = true)
    public Boolean getEmailValidation() {
        return emailValidation;
    }

    public void setEmailValidation(Boolean emailValidation) {
        this.emailValidation = emailValidation;
    }

    @Basic
    @Column(name = "firstName", nullable = false, insertable = true, updatable = true, length = 128)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, insertable = true, updatable = true, length = 128)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "landlinePhoneNumber", nullable = true, insertable = true, updatable = true, length = 128)
    public String getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public void setLandlinePhoneNumber(String landlinePhoneNumber) {
        this.landlinePhoneNumber = landlinePhoneNumber;
    }

    @Basic
    @Column(name = "mobilePhoneNumber", nullable = true, insertable = true, updatable = true, length = 128)
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientInfoEntity that = (ClientInfoEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (landlinePhoneNumber != null ? !landlinePhoneNumber.equals(that.landlinePhoneNumber) : that.landlinePhoneNumber != null)
            return false;
        if (mobilePhoneNumber != null ? !mobilePhoneNumber.equals(that.mobilePhoneNumber) : that.mobilePhoneNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (landlinePhoneNumber != null ? landlinePhoneNumber.hashCode() : 0);
        result = 31 * result + (mobilePhoneNumber != null ? mobilePhoneNumber.hashCode() : 0);
        return result;
    }


}
