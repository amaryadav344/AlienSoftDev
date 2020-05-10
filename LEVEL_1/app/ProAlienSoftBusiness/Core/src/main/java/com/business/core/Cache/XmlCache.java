package com.business.core.Cache;

import com.business.utils.FileHelper;
import com.business.utils.HelperFunctions;
import com.business.utils.XMLWorker;
import com.business.utils.config.BusinessConfig;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.IFile;
import com.business.utils.models.IXMLBase;
import com.business.utils.models.UI.IForm;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Component
public class XmlCache {
    private XMLWorker xmlWorker = XMLWorker.getInstance();
    HashMap<String, IXMLBase> xmls = new HashMap<>();
    Logger logger = Logger.getLogger(this.getClass().getName());

    public void Add(String Key, IXMLBase value) {
        xmls.put(Key, value);
    }

    public IXMLBase Get(String Key) {
        return xmls.get(Key);
    }

    public void LoadXMLCache() {
        try {
            logger.info("Loading XML Cache");
            String text = FileHelper.ReadCompleteFile(HelperFunctions.getExecutableHomePath(MetaDataCache.class, "BusinessConfig.xml"));
            BusinessConfig businessConfig = xmlWorker.readCustomType(text, BusinessConfig.class);
            String PackageName = businessConfig.getConfigValue("PackageName");
            logger.info("Package name " + PackageName);
            String XMLPath = businessConfig.getConfigValue("XMLPath");
            logger.info("XML Path " + XMLPath);
            List<IFile> files = FileHelper.ListAllFiles(XMLPath);
            for (IFile file : files) {
                try {
                    String xmlString = FileHelper.ReadCompleteFile(file.getPath());
                    IXMLBase value = xmlWorker.getXMLObjectFromString(xmlString);
                    if (value instanceof IEntity) {
                        IEntity entity = (IEntity) value;
                        //entity.setName(PackageName + "." + file.getPath().replace(File.separator + file.getName(), "").replace("\\", "") + "." + entity.getModelName());
                        Add(entity.getName(), value);
                    } else if (value instanceof IForm) {
                        IForm form = (IForm) value;
                        Add(form.getName(), value);

                    }
                    logger.info("Loaded xml " + file.getPath());
                } catch (IOException ignored) {
                    logger.info("Exception while loading file " + file.getName() + ":" + ignored.getMessage());
                }
            }
        } catch (IOException ignored) {
            logger.info("Exception while loading metadata Cache : " + ignored.getMessage());
        }
    }
}
