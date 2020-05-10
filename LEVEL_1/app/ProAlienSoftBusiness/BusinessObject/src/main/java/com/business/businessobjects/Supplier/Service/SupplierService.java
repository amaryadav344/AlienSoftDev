package com.business.businessobjects.Supplier.Service;

import com.business.businessobjects.Supplier.Repository.SupplierRepository;
import com.business.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class SupplierService extends ServiceBase {
  private SupplierRepository SupplierRepository;

  @Autowired
  void setSupplierRepository(SupplierRepository SupplierRepository) {
    this.SupplierRepository=SupplierRepository;
  }
}
