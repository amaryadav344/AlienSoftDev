package com.business.businessobjects.Order.Service;

import com.business.businessobjects.Order.Constant.OrderConstants;
import com.business.businessobjects.Order.DTO.Order;
import com.business.businessobjects.Order.Repository.OrderRepository;
import com.business.businessobjects.Order.Validator.OrderValidator;
import com.business.common.base.ServiceBase;
import java.lang.Integer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(OrderConstants.BeanName.ORDER_SERVICE)
public class OrderService extends ServiceBase<Order, Integer> {
  @Autowired
  public OrderService(OrderRepository OrderRepository, OrderValidator OrderValidator) {
    super(OrderRepository, OrderValidator);
  }
}
