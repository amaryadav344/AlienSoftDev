package com.business.core.Controller;


import com.business.common.base.BusBase;
import com.business.common.Reflection.ReflectionHelper;
import com.business.common.base.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@Controller
public class CoreController {
    @Autowired
    HttpSession session;
    @Autowired
    ApplicationContext applicationContext;
    String form = "wfmSupplier";
    String Method = "FindSupplierById";
    String Service = "SupplierService";
    int CustomerId = 3;

    @Autowired
    ReflectionHelper reflectionHelper;

    @RequestMapping(value = "/GetFormForOpen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusBase> GetFormForOpen() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        ServiceBase serviceBase = (ServiceBase) applicationContext.getBean(Service);
        BusBase busBase = (BusBase) reflectionHelper.ExecuteMethod(Method, serviceBase, CustomerId);
        UUID uuid = UUID.randomUUID();
        session.setAttribute("TransactionId" + session.getId(), uuid.toString());
        session.setAttribute(form + "_" + uuid.toString(), busBase);
        return new ResponseEntity<>(busBase, HttpStatus.OK);
    }

    @RequestMapping(value = "/Save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Save() {
        ServiceBase serviceBase = (ServiceBase) applicationContext.getBean(Service);
        String uuid = (String) session.getAttribute("TransactionId" + session.getId());
        BusBase busBase = (BusBase) session.getAttribute(form + "_" + uuid);
        serviceBase.beforePersistChange(busBase);
        serviceBase.persistChange(busBase);
        serviceBase.afterPersistChange(busBase);
        return new ResponseEntity<>(session.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Validate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Validate() {
        ServiceBase serviceBase = (ServiceBase) applicationContext.getBean(Service);
        BusBase busBase = (BusBase) session.getAttribute(form);
        serviceBase.validate(busBase);
        return new ResponseEntity<>(session.getId(), HttpStatus.OK);
    }

}