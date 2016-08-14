
package com.sands.regtest.core.bean;

import com.sands.regtest.core.beanl.IClientServiceBean;
import com.sands.regtest.core.transform.RegistrationRequestToClientInfoEntityTransformer;
import com.sands.regtest.core.transform.TransformerUtil;
import com.sands.regtest.core.util.EmailSenderBean;
import com.sands.regtest.core.util.ValidateAndExecuteData;
import com.sands.regtest.data.RESPONSE;
import com.sands.regtest.data.req.RegistrationRequest;
import com.sands.regtest.data.resp.RegistrationResponse;
import com.sands.regtest.entity.ClientInfoEntity;
import com.sands.regtest.entity.EmailValidationEntity;
import com.sands.regtest.idao.IClientInfoDao;
import com.sands.regtest.idao.IEmailValidationDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Application path for REST services
 */
@Stateless
public class ClientServiceBean implements IClientServiceBean {

    @Inject
    private ValidateAndExecuteData executer;

    @Inject
    private EmailSenderBean emailSenderBean;


    @Inject
    private IClientInfoDao clientInfoDao;

    @Inject
    private IEmailValidationDao emailValidationDao;
    private final String APP_URL = "http://localhost:8060/service-api-1.0-SNAPSHOT/service/v1/client/checkEmail/"; // TODO move to properties

    @Override
    public Response registration(RegistrationRequest request) {

        return executer.call(request, req -> {
            RegistrationResponse response = new RegistrationResponse();
            ClientInfoEntity entity = clientInfoDao.merge(TransformerUtil.parseEntity(request, new RegistrationRequestToClientInfoEntityTransformer()));
            // Write secure message for check email
            EmailValidationEntity validationEntity = new EmailValidationEntity();
            validationEntity.setClientInfoId(entity);
            String secureData = UUID.randomUUID().toString();
            validationEntity.setSecureSequence(secureData);
            emailValidationDao.merge(validationEntity);

            // Send email for check email

            String body = "<a href=\"" + APP_URL +"\"\" + secureData + \"> Confirm email</a>";
            System.out.println("body - " + body);
            emailSenderBean.send(entity.getEmail(), "Confirm email, reg test", body);

            //Send response
            response.setFlag(entity != null);
            System.out.println("req - " + req);
            return RESPONSE._0_OK.createResponse(response, null, null);
        });
    }

    @Override
    public Response checkEmail(String request) {

        return executer.call(request, req -> {
            RegistrationResponse response = new RegistrationResponse();
            EmailValidationEntity validationEntity = emailValidationDao.findBySecureCode(request);
            if(validationEntity != null) {
                ClientInfoEntity clientInfoEntity = validationEntity.getClientInfoId();
                clientInfoEntity.setEmailValidation(true);
                ClientInfoEntity infoEntity = clientInfoDao.merge(clientInfoEntity);

                response.setFlag(infoEntity != null);
                System.out.println("req - " + req);
                return RESPONSE._0_OK.createResponse(response, null, null);
            } else {
                return RESPONSE._10005_INVALID_PARAMETER.createResponse(response, null, null);
            }
        });
    }
}