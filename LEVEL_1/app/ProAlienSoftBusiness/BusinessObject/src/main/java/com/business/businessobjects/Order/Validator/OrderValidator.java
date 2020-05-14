package com.business.businessobjects.Order.Validator;

import com.business.businessobjects.Order.Constant.OrderConstants;
import com.business.businessobjects.Order.DTO.Order;
import com.business.common.base.ValidationBase;
import org.springframework.stereotype.Component;

@Component(OrderConstants.BeanName.ORDER_VALIDATOR)
public class OrderValidator extends ValidationBase<Order> {
}
