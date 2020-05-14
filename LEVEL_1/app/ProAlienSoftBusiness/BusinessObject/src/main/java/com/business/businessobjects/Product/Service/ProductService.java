package com.business.businessobjects.Product.Service;

import com.business.businessobjects.Product.Constant.ProductConstants;
import com.business.businessobjects.Product.DTO.Product;
import com.business.businessobjects.Product.Repository.ProductRepository;
import com.business.businessobjects.Product.Validator.ProductValidator;
import com.business.common.Interface.IValidator;
import com.business.common.base.RepositoryBase;
import com.business.common.base.ServiceBase;

import java.lang.Integer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(ProductConstants.BeanName.PRODUCT_SERVICE)
public class ProductService extends ServiceBase<Product, Integer> {
    @Autowired
    public ProductService(ProductRepository ProductRepository, ProductValidator ProductValidator) {
        super(ProductRepository, ProductValidator);

    }

    public Product FindProductById(Integer ProductId) {
        return repositoryBase.findById(ProductId).get();
    }

    @Override
    public void beforePersistChange(Product entity) {
        super.beforePersistChange(entity);
    }

    @Override
    public void persistChange(Product entity) {
        super.persistChange(entity);
    }


    @Override
    public void afterPersistChange(Product entity) {
        super.afterPersistChange(entity);
    }

    @Override
    public List validate(Product entity) {
        return super.validate(entity);
    }

    @Override
    public List validateGroup(Product entity, Class<?> group) {
        return super.validateGroup(entity, group);
    }
}
