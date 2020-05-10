package com.business.businessobjects.OrderItem.Repository;

import com.business.businessobjects.OrderItem.DTO.OrderItem;
import com.business.common.RepositoryBase;
import java.lang.Integer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("session")
public interface OrderItemRepository extends RepositoryBase<OrderItem, Integer> {
}
