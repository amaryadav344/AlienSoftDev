package com.business.businessobjects.Setting.DTO;

import com.business.common.BusBase;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "AST_SYSTEM_SETTING"
)
public class SystemSetting extends BusBase {
  @Id
  private Integer SystemSettingid;

  private String SettingName;

  private String SettingValue;

  public Integer getSystemSettingid() {
    return SystemSettingid;
  }

  public void setSystemSettingid(Integer SystemSettingid) {
    this.SystemSettingid=SystemSettingid;
  }

  public String getSettingName() {
    return SettingName;
  }

  public void setSettingName(String SettingName) {
    this.SettingName=SettingName;
  }

  public String getSettingValue() {
    return SettingValue;
  }

  public void setSettingValue(String SettingValue) {
    this.SettingValue=SettingValue;
  }
}
