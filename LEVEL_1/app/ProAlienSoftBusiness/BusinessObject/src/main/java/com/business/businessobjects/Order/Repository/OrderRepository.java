package com.business.businessobjects.Order.Repository;

import com.business.businessobjects.Order.Constant.OrderConstants;
import com.business.businessobjects.Order.DTO.Order;
import com.business.common.base.RepositoryBase;
import java.lang.Integer;
import org.springframework.stereotype.Repository;

@Repository(OrderConstants.BeanName.ORDER_REPOSITORY)
public interface OrderRepository extends RepositoryBase<Order, Integer> {
}
