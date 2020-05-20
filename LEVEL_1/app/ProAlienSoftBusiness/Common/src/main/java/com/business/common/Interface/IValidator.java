package com.business.common.Interface;

import com.business.common.Utils.ValidationResult;

import java.util.List;

public interface IValidator<T> {
    public List<ValidationResult> validate(T target);
}
