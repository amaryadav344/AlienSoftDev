package com.business.businessobjects.OrderItem.Validator;

import com.business.businessobjects.OrderItem.Constant.OrderItemConstants;
import com.business.businessobjects.OrderItem.DTO.OrderItem;
import com.business.common.base.ValidationBase;
import org.springframework.stereotype.Component;

@Component(OrderItemConstants.BeanName.ORDERITEM_VALIDATOR)
public class OrderItemValidator extends ValidationBase<OrderItem> {
}
