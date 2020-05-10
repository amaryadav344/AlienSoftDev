package com.business.businessobjects.Order.Service;

import com.business.businessobjects.Order.DTO.Order;
import com.business.businessobjects.Order.Repository.OrderRepository;
import com.business.common.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceBase {
    private OrderRepository OrderRepository;

    @Autowired
    void setOrderRepository(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    public Order FindOrderByID(Integer id) {
        return OrderRepository.findById(id).get();
    }

}
