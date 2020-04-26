package com.business.core.Cache;

import com.business.core.Status;
import com.business.utils.FileHelper;
import com.business.utils.HelperFunctions;
import com.business.utils.XMLWorker;
import com.business.utils.config.BusinessConfig;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.IFile;
import com.business.utils.models.IXMLBase;
import com.business.utils.models.UI.IForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetaDataCache {
    private XMLWorker xmlWorker = XMLWorker.getInstance();
    private XmlCache xmlCache = XmlCache.getInstance();
    private static MetaDataCache mMetaDataCache;

    public static MetaDataCache getInstance() {
        if (mMetaDataCache == null) {
            mMetaDataCache = new MetaDataCache();
        }
        return mMetaDataCache;
    }

    public List<Status> LoadXMLCache() {
        List<Status> statuses = new ArrayList<>();
        try {
            String text = FileHelper.ReadCompleteFile(HelperFunctions.getExecutableHomePath(MetaDataCache.class, "BusinessConfig.xml"));
            BusinessConfig businessConfig = xmlWorker.readCustomType(text, BusinessConfig.class);
            String PackageName = businessConfig.getConfigValue("PackageName");
            String XMLPath = businessConfig.getConfigValue("XMLPath");
            List<IFile> files = FileHelper.ListAllFiles(XMLPath, XMLPath);
            for (IFile file : files) {
                try {
                    String xmlString = FileHelper.ReadCompleteFile(XMLPath + "/" + file.getPath());
                    IXMLBase value = xmlWorker.getXMLObjectFromString(xmlString);
                    if (value instanceof IEntity) {
                        IEntity entity = (IEntity) value;
                        entity.setModelName(PackageName + "." + file.getPath().replace("\\" + file.getName(), "").replace("\\", "") + "." + entity.getModelName());
                        xmlCache.Add(entity.getName(), value);
                        statuses.add(new Status(XMLPath + "/" + file.getPath(), "local"));
                    } else if (value instanceof IForm) {
                        IForm form = (IForm) value;
                        xmlCache.Add(form.getName(), value);
                        statuses.add(new Status(XMLPath + "\\" + file.getPath(), "local"));
                    }
                } catch (IOException ignored) {
                    statuses.add(new Status(XMLPath + "/" + file.getPath(), "error"));
                }
            }
        } catch (IOException ignored) {
            statuses.add(new Status("File Loading Error", "error"));
        }
        return statuses;
    }

    public XmlCache getXmlCache() {
        return xmlCache;
    }
}
