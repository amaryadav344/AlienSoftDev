package com.business.common.Interface;

import java.util.List;

public interface IValidation<T> {
    List validate(T entity);

    List validateGroup(T entity, Class<?> group);
}
