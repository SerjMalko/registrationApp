package com.sands.regtest.core.util;

import com.sands.regtest.data.DefaultResponse;
import com.sands.regtest.data.RESPONSE;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.function.Function;

/**
 * Created by mass on 12.08.2016.
 */
@Stateless
public class ValidateAndExecuteData {

    @Inject
    private Validator validator;

     public <T> Response call(T request, SuccessCallbackFunction successCallback){

         Set<ConstraintViolation<T>> violations = validator
                 .validate(request);

         if (!violations.isEmpty()) {
             // Something is wrong with the data in the bean, report to user (in
             // this example, just print it)
             StringBuilder sb = new StringBuilder();
             violations.forEach(res->{
                 sb.append(res.getPropertyPath() + " -> " + res.getMessage()).append("; ");
             });
             return RESPONSE._10005_INVALID_PARAMETER.createResponse(new DefaultResponse(), null, sb.toString());
         }

         return successCallback.call(request);
     }
}
