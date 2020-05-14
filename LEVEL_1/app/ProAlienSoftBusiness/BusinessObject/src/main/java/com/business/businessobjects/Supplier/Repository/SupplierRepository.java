package com.business.businessobjects.Supplier.Repository;

import com.business.businessobjects.Supplier.Constant.SupplierConstants;
import com.business.businessobjects.Supplier.DTO.Supplier;
import com.business.common.base.RepositoryBase;
import java.lang.Integer;
import org.springframework.stereotype.Repository;

@Repository(SupplierConstants.BeanName.SUPPLIER_REPOSITORY)
public interface SupplierRepository extends RepositoryBase<Supplier, Integer> {
}
