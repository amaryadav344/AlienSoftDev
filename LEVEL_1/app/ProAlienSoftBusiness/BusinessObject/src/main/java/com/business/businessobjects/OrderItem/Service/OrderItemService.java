package com.business.businessobjects.OrderItem.Service;

import com.business.businessobjects.OrderItem.Repository.OrderItemRepository;
import com.business.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class OrderItemService extends ServiceBase {
  private OrderItemRepository OrderItemRepository;

  @Autowired
  void setOrderItemRepository(OrderItemRepository OrderItemRepository) {
    this.OrderItemRepository=OrderItemRepository;
  }
}
