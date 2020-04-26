package com.business.core;


import com.business.businessobjects.BusBase;
import com.business.core.Cache.MetaDataCache;
import com.business.core.Helper.App;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.ILoadMapping;
import com.business.utils.models.UI.IForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class CoreController {
    MetaDataCache metaDataCache = MetaDataCache.getInstance();

    @RequestMapping(value = "/LoadXmlCache", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Status>> getXmlFromObject() {
        List<Status> statuses = metaDataCache.LoadXMLCache();
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @RequestMapping(value = "/GetFormViewModel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ViewModel> getFormViewModel(@RequestParam(name = "form") String form) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IForm xml = (IForm) metaDataCache.getXmlCache().Get(form);
        IEntity entity = (IEntity) metaDataCache.getXmlCache().Get(xml.getEntity());
        Class<?> clazz = Class.forName(entity.getModelName());
        BusBase object = (BusBase) clazz.getDeclaredConstructor().newInstance();
        if (xml.getLoadMethod().getLoadMapping() != null) {
            for (ILoadMapping loadMapping : xml.getLoadMethod().getLoadMapping()) {
                Method method = object.getClass().getMethod(loadMapping.getName());
                method.invoke(object);
            }
        }
        App.getInstance().AddFormObject(form, object);
        ViewModel viewModel = ViewModel.getViewModel(entity, object, xml);
        return new ResponseEntity<>(viewModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/ExecuteBusinessMethod", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ViewModel> ExecuteBusinessMethod(@RequestBody ViewModel model,
                                                           @RequestParam(name = "form") String form,
                                                           @RequestParam(name = "method") String methodName) {
        IForm xml = model.getView();
        IEntity entity = (IEntity) metaDataCache.getXmlCache().Get(xml.getEntity());
        BusBase busBase = App.getInstance().GetFormObject(form);
        Method method = null;
        try {
            method = busBase.getClass().getMethod(methodName);
            method.invoke(busBase);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        ViewModel viewModel = ViewModel.getViewModel(entity, busBase, xml);
        return new ResponseEntity<>(viewModel, HttpStatus.OK);
    }
}
