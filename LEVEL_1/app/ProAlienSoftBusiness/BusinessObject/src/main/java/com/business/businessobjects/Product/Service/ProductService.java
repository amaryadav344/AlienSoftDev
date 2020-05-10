package com.business.businessobjects.Product.Service;

import com.business.businessobjects.Product.Repository.ProductRepository;
import com.business.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class ProductService extends ServiceBase {
  private ProductRepository ProductRepository;

  @Autowired
  void setProductRepository(ProductRepository ProductRepository) {
    this.ProductRepository=ProductRepository;
  }
}
