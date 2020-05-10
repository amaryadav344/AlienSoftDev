package com.business.businessobjects.Setting.Repository;

import com.business.businessobjects.Setting.DTO.SystemSetting;
import com.business.common.RepositoryBase;
import java.lang.Integer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("session")
public interface SystemSettingRepository extends RepositoryBase<SystemSetting, Integer> {
}
