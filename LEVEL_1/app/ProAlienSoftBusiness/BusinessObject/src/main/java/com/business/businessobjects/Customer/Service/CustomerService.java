package com.business.businessobjects.Customer.Service;

import com.business.businessobjects.Customer.Repository.CustomerRepository;
import com.business.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class CustomerService extends ServiceBase {
  private CustomerRepository CustomerRepository;

  @Autowired
  void setCustomerRepository(CustomerRepository CustomerRepository) {
    this.CustomerRepository=CustomerRepository;
  }
}
