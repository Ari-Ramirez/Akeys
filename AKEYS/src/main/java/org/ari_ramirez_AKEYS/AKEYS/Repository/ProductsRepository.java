package org.ari_ramirez_AKEYS.AKEYS.Repository;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products,Integer> {
}
