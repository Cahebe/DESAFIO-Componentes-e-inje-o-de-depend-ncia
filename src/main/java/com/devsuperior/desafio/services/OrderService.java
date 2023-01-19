package com.devsuperior.desafio.services;

import com.devsuperior.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    ShippingService shipping;
    public double total(Order order){
        return order.getBasic() - (order.getDiscount()/100*order.getBasic()) + shipping.shipment(order);
    }

}
