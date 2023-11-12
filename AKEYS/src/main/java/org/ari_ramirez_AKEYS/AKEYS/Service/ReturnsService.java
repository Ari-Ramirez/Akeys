package org.ari_ramirez_AKEYS.AKEYS.Service;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Returns;

import java.util.List;

public interface ReturnsService {
    List<Returns> findAllReturnsByUser(String email);
}
