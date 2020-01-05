package com.business.businesstire.Ui;


import com.business.businesstire.Queue.MessageQueue;
import com.business.businesstire.Util.XmlCache;
import com.business.utils.AppConfigRepository;
import com.business.utils.FileHelper;
import com.business.utils.XMLWorker;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.IFile;
import com.business.utils.models.IXMLBase;
import com.business.utils.models.UI.IForm;

import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class BusinessTire {
    private UIComponent uiComponent;
    private XMLWorker xmlWorker = XMLWorker.getInstance();
    private XmlCache xmlCache = XmlCache.getInstance();

    public static void main(String[] args) throws BadLocationException, IOException, TimeoutException {
        BusinessTire example = new BusinessTire();
        example.Init();

    }

    private void Init() throws BadLocationException, IOException, TimeoutException {
        uiComponent = new UIComponent();
        uiComponent.CreateLayout();
        for (int i = 0; i < 50; i++) {
            LoadXMLCache();
        }
        MessageQueue messageQueue = MessageQueue.getInstance();

        //String EXCHANGE_NAME = "com.business.business-tire";
        /*DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
        };
        messageQueue.getChannel().basicConsume(EXCHANGE_NAME, true, deliverCallback, consumerTag -> {
        });*/
    }

    public void LoadXMLCache() throws BadLocationException {
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
                        xmlCache.Add(entity.getName(), value);
                        uiComponent.AddText("Loaded Entity " + entity.getName(), Color.GREEN);
                    } else if (value instanceof IForm) {
                        IForm form = (IForm) value;
                        xmlCache.Add(form.getName(), value);
                        uiComponent.AddText("Loaded Form " + form.getName(), Color.GREEN);
                    }
                } catch (IOException exception) {
                    uiComponent.AddText("Exception at" + exception.getMessage(), Color.RED);
                }
            }
        } catch (IOException exception) {
            uiComponent.AddText("Exception at" + exception.getMessage(), Color.RED);
        }

    }
}
