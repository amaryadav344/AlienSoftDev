package com.business.common.base;

import com.business.common.Interface.IPersistent;
import com.business.common.Interface.IValidation;
import com.business.common.Interface.IValidator;
import com.business.common.Utils.ValidationResult;

import java.util.List;

public abstract class ServiceBase<T extends BusBase, ID> implements IPersistent<T>, IValidation<T> {
    protected RepositoryBase<T, ID> repositoryBase;
    protected IValidator validator;
    protected List<ValidationResult> errors;

    public ServiceBase(RepositoryBase<T, ID> repositoryBase, IValidator validator) {
        this.repositoryBase = repositoryBase;
        this.validator = validator;
    }

    @Override
    public void beforePersistChange(T entity) {
        repositoryBase.save(entity);
    }

    @Override
    public void persistChange(T entity) {
    }

    @Override
    public void afterPersistChange(T entity) {

    }

    @Override
    public List validate(T entity) {
        return validator.validate(entity);
    }

    @Override
    public List validateGroup(T entity, Class<?> group) {
        return validator.validate(entity);
    }
}
