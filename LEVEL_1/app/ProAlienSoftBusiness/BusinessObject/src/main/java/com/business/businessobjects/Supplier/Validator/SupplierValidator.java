package com.business.businessobjects.Supplier.Validator;

import com.business.businessobjects.Supplier.Constant.SupplierConstants;
import com.business.businessobjects.Supplier.DTO.Supplier;
import com.business.common.base.ValidationBase;
import org.springframework.stereotype.Component;

@Component(SupplierConstants.BeanName.SUPPLIER_VALIDATOR)
public class SupplierValidator extends ValidationBase<Supplier> {
}
