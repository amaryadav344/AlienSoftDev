package com.business.businessobjects.OrderItem.Service;

import com.business.businessobjects.OrderItem.Constant.OrderItemConstants;
import com.business.businessobjects.OrderItem.DTO.OrderItem;
import com.business.businessobjects.OrderItem.Repository.OrderItemRepository;
import com.business.businessobjects.OrderItem.Validator.OrderItemValidator;
import com.business.common.base.ServiceBase;
import java.lang.Integer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(OrderItemConstants.BeanName.ORDERITEM_SERVICE)
public class OrderItemService extends ServiceBase<OrderItem, Integer> {
  @Autowired
  public OrderItemService(OrderItemRepository OrderItemRepository,
      OrderItemValidator OrderItemValidator) {
    super(OrderItemRepository, OrderItemValidator);
  }
}
