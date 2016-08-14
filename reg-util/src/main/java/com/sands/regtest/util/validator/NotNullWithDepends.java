package com.sands.regtest.util.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullWithDependsValidator.class)
public @interface NotNullWithDepends {

    String message() default "Can not be null!" ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String targetFieldName();

    String dependentFieldName();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotNullWithDepends[] value();
    }
}