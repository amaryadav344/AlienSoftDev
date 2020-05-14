package com.business.common.Interface;

import com.business.common.Utils.UtlError;

import java.util.List;

public interface IValidator<T> {
    public List<UtlError> validate(T target);
}
