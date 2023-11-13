package org.ari_ramirez_AKEYS.AKEYS.ServiceTest;

import org.ari_ramirez_AKEYS.AKEYS.DTO.UserDTO;
import org.ari_ramirez_AKEYS.AKEYS.Repository.UserRepository;
import org.ari_ramirez_AKEYS.AKEYS.Service.UserService;
import org.ari_ramirez_AKEYS.AKEYS.TestDatabaseConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@SpringBootTest
@TestMethodOrder(MethodOrderer.class)

public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    UserDTO userDTO;


    @BeforeEach
    public void init(){


        userDTO = new UserDTO();
        userDTO.setEmail("test100@test.com");
        userDTO.setPassword("Perscholas1");
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
    }

    @Test
    @Order(1)
    public void testSaveUser(){
        userService.saveUser(userDTO);
        Assertions.assertTrue(userRepository.count() > 0);
    }

    @Test
    @Order(2)
    public void testFindUserByEmail(){
        UserDTO userDTOActual = userService.findUserByEmail("test100@test.com");

        Assertions.assertEquals("test100@test.com", userDTOActual.getEmail());
    }


}
