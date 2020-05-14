package com.business.businessobjects.Setting.Validator;

import com.business.businessobjects.Setting.Constant.SystemSettingConstants;
import com.business.businessobjects.Setting.DTO.SystemSetting;
import com.business.common.base.ValidationBase;
import org.springframework.stereotype.Component;

@Component(SystemSettingConstants.BeanName.SYSTEMSETTING_VALIDATOR)
public class SystemSettingValidator extends ValidationBase<SystemSetting> {
}
