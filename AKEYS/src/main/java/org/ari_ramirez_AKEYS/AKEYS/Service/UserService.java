package org.ari_ramirez_AKEYS.AKEYS.Service;

import org.ari_ramirez_AKEYS.AKEYS.DTO.UserDTO;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String username);
    public UserDTO findUserByEmail(String email);

    public User findUserByEmailForSecurity(String email);
    public void saveUser(UserDTO userDTO);

}
