package com.business.businessobjects.OrderItem.Validation;

import com.business.businessobjects.OrderItem.DTO.OrderItem;
import java.lang.Override;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderItemValidator implements ConstraintValidator<ValidOrderItem, OrderItem> {
  @Override
  public boolean isValid(OrderItem OrderItem,
      ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
}
