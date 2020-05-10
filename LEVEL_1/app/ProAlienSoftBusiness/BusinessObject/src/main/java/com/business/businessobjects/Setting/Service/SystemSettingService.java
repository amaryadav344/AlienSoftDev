package com.business.businessobjects.Setting.Service;

import com.business.businessobjects.Setting.Repository.SystemSettingRepository;
import com.business.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class SystemSettingService extends ServiceBase {
  private SystemSettingRepository SystemSettingRepository;

  @Autowired
  void setSystemSettingRepository(SystemSettingRepository SystemSettingRepository) {
    this.SystemSettingRepository=SystemSettingRepository;
  }
}
