package com.business.businessobjects.Product.Validation;

import com.business.businessobjects.Product.DTO.Product;
import java.lang.Override;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ValidProduct, Product> {
  @Override
  public boolean isValid(Product Product, ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
}
