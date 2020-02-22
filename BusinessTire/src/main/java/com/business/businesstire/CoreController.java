package com.business.businesstire;


import com.business.businessobjects.BusBase;
import com.business.businesstire.Cache.MetaDataCache;
import com.business.businesstire.Cache.XmlCache;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.ILoadMapping;
import com.business.utils.models.UI.IForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Controller
public class CoreController {
    MetaDataCache metaDataCache = MetaDataCache.getInstance();

    @RequestMapping(value = "/LoadXmlCache", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getXmlFromObject() {

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/GetFormViewModel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ViewModel> getFormViewModel(@RequestParam(name = "form") String form) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IForm xml = (IForm) metaDataCache.getXmlCache().Get(form);
        IEntity entity = (IEntity) metaDataCache.getXmlCache().Get(xml.getEntity());
        Class<?> clazz = Class.forName(entity.getModelName());
        BusBase object = (BusBase) clazz.getDeclaredConstructor().newInstance();
        for (ILoadMapping loadMapping : xml.getLoadMethod().getLoadMapping()) {
            Method method = object.getClass().getMethod(loadMapping.getName());
            method.invoke(object);
        }
        ViewModel viewModel = ViewModel.getViewModel(entity, object, xml);
        return new ResponseEntity<>(viewModel, HttpStatus.OK);
    }

    @PostConstruct
    public void LoadXMLCache() {
        metaDataCache.LoadXMLCache();
    }


}
