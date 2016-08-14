package com.sands.regtest.core.transform;

import com.sands.regtest.data.req.RegistrationRequest;
import com.sands.regtest.entity.ClientInfoEntity;

/**
 * Created by mass on 01.02.2016.
 */
public class RegistrationRequestToClientInfoEntityTransformer implements ITransformer<RegistrationRequest, ClientInfoEntity> {
    @Override
    public ClientInfoEntity parseToResponseEntity(RegistrationRequest entity) {
        ClientInfoEntity data = new ClientInfoEntity();
        data.setFirstName(entity.getFirstName());
        data.setLastName(entity.getLastName());
        data.setEmail(entity.getEmail());
        data.setPassword(entity.getPassword());
        data.setLandlinePhoneNumber(entity.getLandlinePhoneNumber());
        data.setMobilePhoneNumber(entity.getMobilePhoneNumber());
        return data;
    }
}
