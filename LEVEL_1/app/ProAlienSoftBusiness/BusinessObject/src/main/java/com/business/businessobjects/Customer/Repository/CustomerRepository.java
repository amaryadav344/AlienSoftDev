package com.business.businessobjects.Customer.Repository;

import com.business.businessobjects.Customer.Constant.CustomerConstants;
import com.business.businessobjects.Customer.DTO.Customer;
import com.business.common.base.RepositoryBase;
import java.lang.Integer;
import org.springframework.stereotype.Repository;

@Repository(CustomerConstants.BeanName.CUSTOMER_REPOSITORY)
public interface CustomerRepository extends RepositoryBase<Customer, Integer> {
}
