package com.business.businessobjects.Customer.Validation;

import com.business.businessobjects.Customer.DTO.Customer;
import java.lang.Override;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<ValidCustomer, Customer> {
  @Override
  public boolean isValid(Customer Customer, ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
}
