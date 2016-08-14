package com.sands.regtest.api.util.filter;

import com.sands.regtest.data.DefaultResponse;
import com.sands.regtest.data.RESPONSE;
import com.sands.regtest.data.req.RegistrationRequest;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Set;

/**
 * REST Logging request filter
 * <p>
 * Created by ava on 09.09.2015.
 */
public class ValidationDataValidator implements ConstraintValidator<ValidData, Object> {

    @Inject
    private Validator validator;
    @Inject

    public void initialize(ValidData target) {
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Set<ConstraintViolation<Object>> violations = validator
                .validate(value);

        if (!violations.isEmpty()) {
            // Something is wrong with the data in the bean, report to user (in
            // this example, just print it)
            StringBuilder sb = new StringBuilder();
            violations.forEach(res -> {
                sb.append(res.getPropertyPath() + " -> " + res.getMessage()).append("; ");
            });
            context.buildConstraintViolationWithTemplate(sb.toString());
//            requestContext.abortWith(RESPONSE._10005_INVALID_PARAMETER.createResponse(new DefaultResponse(), null, sb.toString()));
//
//            return RESPONSE._10005_INVALID_PARAMETER.createResponse(response, null, sb.toString());
        } else {
            return true;
        }
        return false;
    }
}