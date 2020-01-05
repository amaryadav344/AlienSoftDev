package com.business.businessobjects.Person;

public class dobusSystemsettings {
  public Integer system_settingid;

  public String setting_name;

  public String setting_value;

  public Integer getsystem_settingid() {
    return system_settingid;
  }

  public void setsystem_settingid(Integer system_settingid) {
    this.system_settingid=system_settingid;
  }

  public String getsetting_name() {
    return setting_name;
  }

  public void setsetting_name(String setting_name) {
    this.setting_name=setting_name;
  }

  public String getsetting_value() {
    return setting_value;
  }

  public void setsetting_value(String setting_value) {
    this.setting_value=setting_value;
  }
}
