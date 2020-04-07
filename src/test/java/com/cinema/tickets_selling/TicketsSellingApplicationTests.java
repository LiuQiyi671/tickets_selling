package com.cinema.tickets_selling;

import com.cinema.tickets_selling.dao.UserMapper;
import com.cinema.tickets_selling.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TicketsSellingApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUser() {

        List<User> users = this.userMapper.selectList(null);
        for (User user : users){
            System.out.println(user);
        }
    }

}
