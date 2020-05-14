package com.business.businessobjects.Setting.Service;

import com.business.businessobjects.Setting.Constant.SystemSettingConstants;
import com.business.businessobjects.Setting.DTO.SystemSetting;
import com.business.businessobjects.Setting.Repository.SystemSettingRepository;
import com.business.businessobjects.Setting.Validator.SystemSettingValidator;
import com.business.common.base.ServiceBase;
import java.lang.Integer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(SystemSettingConstants.BeanName.SYSTEMSETTING_SERVICE)
public class SystemSettingService extends ServiceBase<SystemSetting, Integer> {
  @Autowired
  public SystemSettingService(SystemSettingRepository SystemSettingRepository,
      SystemSettingValidator SystemSettingValidator) {
    super(SystemSettingRepository, SystemSettingValidator);
  }
}
