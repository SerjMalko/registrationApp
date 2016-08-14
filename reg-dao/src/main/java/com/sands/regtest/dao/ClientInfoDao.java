package com.sands.regtest.dao;

import com.sands.regtest.entity.ClientInfoEntity;
import com.sands.regtest.idao.IClientInfoDao;

import javax.ejb.Stateless;

/**
 * Created by mass on 13.08.2016.
 */
@Stateless
public class ClientInfoDao extends AbstractDao<ClientInfoEntity> implements IClientInfoDao {
}
