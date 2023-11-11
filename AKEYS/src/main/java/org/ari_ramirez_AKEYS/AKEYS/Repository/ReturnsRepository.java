package org.ari_ramirez_AKEYS.AKEYS.Repository;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Returns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnsRepository extends CrudRepository<Returns,Integer> {
}
