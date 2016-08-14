package com.sands.regtest.idao;

import com.sands.regtest.entity.ClientInfoEntity;

import javax.ejb.Local;

/**
 * Created by mass on 13.08.2016.
 */
@Local
public interface IClientInfoDao extends IAbstractDao<ClientInfoEntity> {
}
