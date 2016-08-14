package com.sands.regtest.api.util.filter;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Определяет необходимость логирования (для REST-сервисов)
 *
 * Created by ava on 10.09.2015.
 */
@Constraint(validatedBy = ValidationDataValidator.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ValidData {

    String message() default "Not valid!" ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
