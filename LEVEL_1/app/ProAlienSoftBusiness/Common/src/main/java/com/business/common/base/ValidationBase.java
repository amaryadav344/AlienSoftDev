package com.business.common.base;

import com.business.common.Interface.IValidator;
import com.business.common.Utils.UtlError;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ValidationBase<T> implements IValidator<T> {


    @Override
    public List<UtlError> validate(T target) {
        List<UtlError> errors = new ArrayList<>();
        javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.add(new UtlError(UtlError.TYPE.ERROR, message));
        }
        return errors;
    }
}
