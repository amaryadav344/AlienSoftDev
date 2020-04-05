package com.business.businesstire.Cache;

import com.business.utils.AppConfigRepository;
import com.business.utils.FileHelper;
import com.business.utils.XMLWorker;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.IFile;
import com.business.utils.models.IXMLBase;
import com.business.utils.models.UI.IForm;

import java.io.IOException;
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

    public void LoadXMLCache() {
        try {
            AppConfigRepository repository = AppConfigRepository.getInstance();
            String XmlPath = repository.getAppConfig(AppConfigRepository.BASE_DIRECTORY) + repository.getAppConfig(AppConfigRepository.XML_RELATIVE_PATH);
            List<IFile> files = FileHelper.ListAllFiles(XmlPath, XmlPath);
            for (IFile file : files) {
                try {
                    String xmlString = FileHelper.ReadCompleteFile(XmlPath + "/" + file.getPath());
                    IXMLBase value = xmlWorker.getXMLObjectFromString(xmlString);
                    if (value instanceof IEntity) {
                        IEntity entity = (IEntity) value;
                        entity.setModelName("com.business.businessobjects" + "." + file.getPath().replace("\\" + file.getName(), "").replace("\\", "") + "." + entity.getModelName());
                        xmlCache.Add(entity.getName(), value);
                    } else if (value instanceof IForm) {
                        IForm form = (IForm) value;
                        xmlCache.Add(form.getName(), value);
                    }
                } catch (IOException exception) {
                }
            }
        } catch (IOException exception) {
        }

    }

    public XmlCache getXmlCache() {
        return xmlCache;
    }
}
