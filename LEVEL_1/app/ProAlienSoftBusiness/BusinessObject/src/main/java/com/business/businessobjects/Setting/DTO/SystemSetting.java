package com.business.businessobjects.Setting.DTO;

import com.business.common.base.BusBase;
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
  private Integer SystemSettingId;

  private String SettingName;

  private String SettingValue;

  public Integer getSystemSettingId() {
    return SystemSettingId;
  }

  public void setSystemSettingId(Integer SystemSettingId) {
    this.SystemSettingId=SystemSettingId;
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
