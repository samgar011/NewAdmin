package com.example.newadmin;

import com.example.newadmin.user.User;
import com.example.newadmin.user.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class NewAdminApplicationTests {

   @Autowired private UserRepo repo;

   @Test
   public void testAddItem(){
      User user = new User();
      user.setEmail("sample@email.com");
      user.setAdress(" sample adress");
      user.setFirstname("sampleuser");
      user.setLastname("samplelastname");
      user.setUsername("user");
      user.setJobtitle("samplejob");
      user.setPassword("root");


      repo.save(user);

   }





}
