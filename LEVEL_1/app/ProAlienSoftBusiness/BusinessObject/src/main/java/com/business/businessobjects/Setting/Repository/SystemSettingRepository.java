package com.business.businessobjects.Setting.Repository;

import com.business.businessobjects.Setting.Constant.SystemSettingConstants;
import com.business.businessobjects.Setting.DTO.SystemSetting;
import com.business.common.base.RepositoryBase;
import java.lang.Integer;
import org.springframework.stereotype.Repository;

@Repository(SystemSettingConstants.BeanName.SYSTEMSETTING_REPOSITORY)
public interface SystemSettingRepository extends RepositoryBase<SystemSetting, Integer> {
}
