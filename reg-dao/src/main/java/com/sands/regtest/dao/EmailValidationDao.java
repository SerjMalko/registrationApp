package com.sands.regtest.dao;

import com.sands.regtest.entity.ClientInfoEntity;
import com.sands.regtest.entity.EmailValidationEntity;
import com.sands.regtest.idao.IClientInfoDao;
import com.sands.regtest.idao.IEmailValidationDao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by mass on 13.08.2016.
 */
@Stateless
public class EmailValidationDao extends AbstractDao<EmailValidationEntity> implements IEmailValidationDao {

    @Override
    public EmailValidationEntity findBySecureCode(String secureSequence) {
        try{

            Query query = em.createQuery("Select e FROM EmailValidationEntity e WHERE e.secureSequence = :secureSequence");
            query.setParameter("secureSequence", secureSequence);
            EmailValidationEntity result = (EmailValidationEntity)query.getSingleResult();
            return result;
        } catch(NoResultException e) {
            return null;
        }
    }
}
