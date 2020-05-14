package com.business.businessobjects.OrderItem.Repository;

import com.business.businessobjects.OrderItem.Constant.OrderItemConstants;
import com.business.businessobjects.OrderItem.DTO.OrderItem;
import com.business.common.base.RepositoryBase;
import java.lang.Integer;
import org.springframework.stereotype.Repository;

@Repository(OrderItemConstants.BeanName.ORDERITEM_REPOSITORY)
public interface OrderItemRepository extends RepositoryBase<OrderItem, Integer> {
}
