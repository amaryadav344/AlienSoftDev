package com.business.common.Utils;

import com.business.utils.FileHelper;
import com.business.utils.HelperFunctions;
import com.business.utils.XMLWorker;
import com.business.utils.config.BusinessConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component("BusinessApp")
public class BusinessApp {
    private BusinessConfig businessConfig;

    public void setBusinessConfig(BusinessConfig businessConfig) {
        this.businessConfig = businessConfig;
    }

    public BusinessConfig getBusinessConfig() {
        return businessConfig;
    }

    @PostConstruct
    public void LoadBusinessApp() throws IOException {
        String content2 = FileHelper.ReadCompleteFile(HelperFunctions.getExecutableHomePath(BusinessApp.class, "BusinessConfig.xml"));
        BusinessConfig businessConfig = XMLWorker.getInstance().readCustomType(content2, BusinessConfig.class);
        setBusinessConfig(businessConfig);
    }
}
