package com.sands.regtest.util.validator;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NotNullWithDependsValidator
        implements ConstraintValidator<NotNullWithDepends, Object> {

    private String targetFieldName;
    private String dependentFieldName;

    @Override
    public void initialize(final NotNullWithDepends a) {
        this.targetFieldName = a.targetFieldName();
        this.dependentFieldName = a.dependentFieldName();
    }

    @Override
    public boolean isValid(
            final Object t, final ConstraintValidatorContext cvc) {
        final Object targetFieldData;
        final Object dependentFieldData;
        try {
            targetFieldData = BeanUtils.getProperty(t,
                    this.targetFieldName);
            dependentFieldData = BeanUtils.getProperty(t,
                    this.dependentFieldName);
            System.out.println("Validation targetFieldData - " + targetFieldData + "; dependentFieldData - " + dependentFieldData);
            /* Validation logic goes here */
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        if ((targetFieldData != null && !((String)targetFieldData).isEmpty())
                || (dependentFieldData != null && !((String)dependentFieldData).isEmpty())) { return true; }

        // return false, just to make it always fail
        return false;
    }
}