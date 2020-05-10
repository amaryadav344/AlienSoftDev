package com.business.businessobjects.Supplier.Validation;

import com.business.businessobjects.Supplier.DTO.Supplier;
import java.lang.Override;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SupplierValidator implements ConstraintValidator<ValidSupplier, Supplier> {
  @Override
  public boolean isValid(Supplier Supplier, ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
}
