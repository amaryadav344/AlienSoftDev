package com.business.businessobjects.Setting.Validation;

import com.business.businessobjects.Setting.DTO.SystemSetting;
import java.lang.Override;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SystemSettingValidator implements ConstraintValidator<ValidSystemSetting, SystemSetting> {
  @Override
  public boolean isValid(SystemSetting SystemSetting,
      ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
}
