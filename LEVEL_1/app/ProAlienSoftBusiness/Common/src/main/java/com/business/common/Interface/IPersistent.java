package com.business.common.Interface;

public interface IPersistent<T> {
    void beforePersistChange(T entity);

    void persistChange(T entity);

    void afterPersistChange(T entity);
}
