package com.business.core.Cache;

import com.business.utils.FileHelper;
import com.business.utils.HelperFunctions;
import com.business.utils.XMLWorker;
import com.business.utils.config.BusinessConfig;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.IFile;
import com.business.utils.models.IXMLBase;
import com.business.utils.models.UI.IForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MetaDataCache {
    private XmlCache xmlCache;
    Logger logger = Logger.getLogger(this.getClass().getName());


    public XmlCache getXmlCache() {
        return xmlCache;
    }

    public void LoadCache() {
        xmlCache.LoadXMLCache();
    }

    @Autowired
    public void setXmlCache(XmlCache xmlCache) {
        this.xmlCache = xmlCache;
    }
}
