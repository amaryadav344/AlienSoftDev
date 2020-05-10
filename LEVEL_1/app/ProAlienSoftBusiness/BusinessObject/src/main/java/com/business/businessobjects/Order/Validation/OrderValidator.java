package com.business.businessobjects.Order.Validation;

import com.business.businessobjects.Order.DTO.Order;
import java.lang.Override;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderValidator implements ConstraintValidator<ValidOrder, Order> {
  @Override
  public boolean isValid(Order Order, ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
}
