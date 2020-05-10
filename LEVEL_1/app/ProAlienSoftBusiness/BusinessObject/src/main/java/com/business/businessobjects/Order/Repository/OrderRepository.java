package com.business.businessobjects.Order.Repository;

import com.business.businessobjects.Order.DTO.Order;
import com.business.common.RepositoryBase;

import java.lang.Integer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

@Repository
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public interface OrderRepository extends RepositoryBase<Order, Integer> {
}
