package com.business.businessobjects.Customer.Validator;

import com.business.businessobjects.Customer.Constant.CustomerConstants;
import com.business.businessobjects.Customer.DTO.Customer;
import com.business.common.base.ValidationBase;
import org.springframework.stereotype.Component;

@Component(CustomerConstants.BeanName.CUSTOMER_VALIDATOR)
public class CustomerValidator extends ValidationBase<Customer> {
}
