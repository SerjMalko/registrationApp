package com.sands.regtest.entity;

import javax.persistence.*;

/**
 * Created by mass on 14.08.2016.
 */
@Entity
@Table(name = "email_validation")
public class EmailValidationEntity {
    private int id;
    private String secureSequence;
    private ClientInfoEntity clientInfoId;

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
    @Column(name = "secureSequence", nullable = true, insertable = true, updatable = true, length = 128)
    public String getSecureSequence() {
        return secureSequence;
    }

    public void setSecureSequence(String secureSequence) {
        this.secureSequence = secureSequence;
    }

    @ManyToOne
    @JoinColumn(name="clientInfoId")
    public ClientInfoEntity getClientInfoId() {
        return clientInfoId;
    }

    public void setClientInfoId(ClientInfoEntity clientInfoId) {
        this.clientInfoId = clientInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailValidationEntity that = (EmailValidationEntity) o;

        if (id != that.id) return false;
        if (secureSequence != null ? !secureSequence.equals(that.secureSequence) : that.secureSequence != null)
            return false;
        if (clientInfoId != null ? !clientInfoId.equals(that.clientInfoId) : that.clientInfoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (secureSequence != null ? secureSequence.hashCode() : 0);
        result = 31 * result + (clientInfoId != null ? clientInfoId.hashCode() : 0);
        return result;
    }
}
