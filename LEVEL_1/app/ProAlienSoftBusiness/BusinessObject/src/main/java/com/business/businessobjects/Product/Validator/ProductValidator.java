package com.business.businessobjects.Product.Validator;

import com.business.businessobjects.Product.Constant.ProductConstants;
import com.business.businessobjects.Product.DTO.Product;
import com.business.common.Utils.ValidationResult;
import com.business.common.base.ValidationBase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(ProductConstants.BeanName.PRODUCT_VALIDATOR)
public class ProductValidator extends ValidationBase<Product> {
    @Override
    public List<ValidationResult> validate(Product target) {
        return super.validate(target);
    }
}
