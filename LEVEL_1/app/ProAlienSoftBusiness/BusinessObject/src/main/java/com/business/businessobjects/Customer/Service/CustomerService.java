package com.business.businessobjects.Customer.Service;

import com.business.businessobjects.Customer.Constant.CustomerConstants;
import com.business.businessobjects.Customer.DTO.Customer;
import com.business.businessobjects.Customer.Repository.CustomerRepository;
import com.business.businessobjects.Customer.Validator.CustomerValidator;
import com.business.common.base.ServiceBase;
import java.lang.Integer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(CustomerConstants.BeanName.CUSTOMER_SERVICE)
public class CustomerService extends ServiceBase<Customer, Integer> {
  @Autowired
  public CustomerService(CustomerRepository CustomerRepository,
      CustomerValidator CustomerValidator) {
    super(CustomerRepository, CustomerValidator);
  }
}
