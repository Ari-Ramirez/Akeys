package org.ari_ramirez_AKEYS.AKEYS.Repository;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Orders;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Integer> {
    List<Orders> findByUser(User user);
}
