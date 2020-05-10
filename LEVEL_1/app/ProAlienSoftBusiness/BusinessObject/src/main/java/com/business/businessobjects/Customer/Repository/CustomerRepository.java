package com.business.businessobjects.Customer.Repository;

import com.business.businessobjects.Customer.DTO.Customer;
import com.business.common.RepositoryBase;
import java.lang.Integer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("session")
public interface CustomerRepository extends RepositoryBase<Customer, Integer> {
}
