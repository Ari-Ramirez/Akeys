package org.ari_ramirez_AKEYS.AKEYS.Repository;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Products;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Products,Integer> {
    List<Products> findAllByUser(User user);
}
