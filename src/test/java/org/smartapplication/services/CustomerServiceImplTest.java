package org.smartapplication.services;

import org.junit.jupiter.api.Test;
import org.smartapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void testThatUserCanHaveAnAccount(){
        UserResponse userResponse = new UserResponse();
        userResponse.
    }

}