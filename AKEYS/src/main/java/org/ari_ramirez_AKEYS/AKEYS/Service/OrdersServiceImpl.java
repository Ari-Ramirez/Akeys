package org.ari_ramirez_AKEYS.AKEYS.Service;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Orders;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.ari_ramirez_AKEYS.AKEYS.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> getOrdersByUser(User user) {
        return ordersRepository.findByUser(user);
    }
}