package com.sands.regtest.idao;

import com.sands.regtest.entity.ClientInfoEntity;
import com.sands.regtest.entity.EmailValidationEntity;

import javax.ejb.Local;

/**
 * Created by mass on 13.08.2016.
 */
@Local
public interface IEmailValidationDao extends IAbstractDao<EmailValidationEntity> {
    /**
     * Find by secure code
     * @param secureSequence
     * @return
     */
    EmailValidationEntity findBySecureCode(String secureSequence);
}
