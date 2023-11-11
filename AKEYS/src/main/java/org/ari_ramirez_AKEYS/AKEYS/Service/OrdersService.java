package org.ari_ramirez_AKEYS.AKEYS.Service;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Orders;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;

import java.util.List;

public interface OrdersService {
    List<Orders> getOrdersByUser(User user);

}