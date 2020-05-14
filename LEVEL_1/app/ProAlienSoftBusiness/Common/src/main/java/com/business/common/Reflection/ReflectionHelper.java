package com.business.common.Reflection;

import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ReflectionHelper {
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Object ExecuteMethod(String methodName, Object object, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?>[] ParameterTypes = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            ParameterTypes[i] = parameters[i].getClass();
        }
        Method method = ClassUtils.getMethod(object.getClass(), methodName, ParameterTypes);
        return method.invoke(object, parameters);
    }
}
