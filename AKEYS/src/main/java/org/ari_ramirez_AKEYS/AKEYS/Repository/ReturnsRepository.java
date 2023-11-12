package org.ari_ramirez_AKEYS.AKEYS.Repository;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Returns;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnsRepository extends CrudRepository<Returns,Integer> {
    List<Returns> findAllByUser(User user);
}
