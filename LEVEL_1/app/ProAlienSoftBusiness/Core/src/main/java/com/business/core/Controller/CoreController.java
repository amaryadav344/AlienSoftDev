package com.business.core.Controller;


import com.business.businessobjects.Order.DTO.Order;
import com.business.businessobjects.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class CoreController {
    private OrderService orderService;
    @Autowired
    HttpSession session;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    /*@RequestMapping(value = "/GetFormViewModel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ViewModel> getFormViewModel(@RequestParam(name = "form") String form) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
      *//*  IForm xml = (IForm) metaDataCache.getXmlCache().Get(form);
        IEntity entity = (IEntity) metaDataCache.getXmlCache().Get(xml.getEntity());
        Class<?> clazz = Class.forName(entity.getModelName());
        BusBase object = (BusBase) clazz.getDeclaredConstructor().newInstance();
        if (xml.getLoadMethod().getLoadMapping() != null) {
            for (ILoadMapping loadMapping : xml.getLoadMethod().getLoadMapping()) {
                Method method = object.getClass().getMethod(loadMapping.getName());
                method.invoke(object);
            }
        }
        App.getInstance().AddFormObject(form, object);*//*
        ViewModel viewModel = ViewModel.getViewModel(entity, object, xml);
        return new ResponseEntity<>(viewModel, HttpStatus.OK);
    }*/

    /*@RequestMapping(value = "/ExecuteBusinessMethod", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
        return new ResponseEntity<>(viewModel, HttpStatus.OK);*/
    //}

    @RequestMapping(value = "/GetFormForOpen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> GetFormForOpen() {
        Order order = orderService.FindOrderByID(1);
        session.setAttribute("wfmPerson", order);
        return new ResponseEntity<>(session.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Save() {
        Order order = orderService.FindOrderByID(1);
        return new ResponseEntity<>(session.getId(), HttpStatus.OK);
    }

}