package com.business.businessobjects.Supplier.Service;

import com.business.businessobjects.Supplier.Constant.SupplierConstants;
import com.business.businessobjects.Supplier.DTO.Supplier;
import com.business.businessobjects.Supplier.Repository.SupplierRepository;
import com.business.businessobjects.Supplier.Validator.SupplierValidator;
import com.business.common.base.ServiceBase;

import java.lang.Integer;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(SupplierConstants.BeanName.SUPPLIER_SERVICE)
public class SupplierService extends ServiceBase<Supplier, Integer> {
    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public SupplierService(SupplierRepository SupplierRepository,
                           SupplierValidator SupplierValidator) {
        super(SupplierRepository, SupplierValidator);
    }

    @Transactional
    public Supplier FindSupplierById(Integer id) {
        Supplier supplier = repositoryBase.findById(id).get();
        supplier.getProducts().forEach(product -> logger.info("Product" + product.getId()));
        return supplier;
    }
}
