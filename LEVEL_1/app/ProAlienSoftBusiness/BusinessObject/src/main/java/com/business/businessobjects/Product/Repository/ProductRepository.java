package com.business.businessobjects.Product.Repository;

import com.business.businessobjects.Product.Constant.ProductConstants;
import com.business.businessobjects.Product.DTO.Product;
import com.business.common.base.RepositoryBase;
import java.lang.Integer;
import org.springframework.stereotype.Repository;

@Repository(ProductConstants.BeanName.PRODUCT_REPOSITORY)
public interface ProductRepository extends RepositoryBase<Product, Integer> {

}
