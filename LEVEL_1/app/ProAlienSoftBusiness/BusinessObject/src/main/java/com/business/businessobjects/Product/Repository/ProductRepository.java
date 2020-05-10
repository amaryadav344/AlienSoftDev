package com.business.businessobjects.Product.Repository;

import com.business.businessobjects.Product.DTO.Product;
import com.business.common.RepositoryBase;
import java.lang.Integer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("session")
public interface ProductRepository extends RepositoryBase<Product, Integer> {
}
