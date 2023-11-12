package org.ari_ramirez_AKEYS.AKEYS.Service;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Returns;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.ari_ramirez_AKEYS.AKEYS.Repository.ReturnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnsServiceImpl implements ReturnsService{

    private final ReturnsRepository returnsRepository;

    @Autowired
    public ReturnsServiceImpl(ReturnsRepository returnsRepository) {
        this.returnsRepository = returnsRepository;
    }

    @Override
    public List<Returns> findAllReturnsByUser(String email) {
        User user = new User();
        user.setEmail(email);
        return returnsRepository.findAllByUser(user);
    }
}
