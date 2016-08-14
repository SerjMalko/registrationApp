
package com.sands.regtest.core.beanl;

import com.sands.regtest.data.req.EmailValidationRequest;
import com.sands.regtest.data.req.RegistrationRequest;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface IClientServiceBean {
    Response registration(RegistrationRequest request);

    Response checkEmail(String request);
}