package com.chnu.pavel.telephone;

import com.chnu.pavel.telephone.dao.user.interfaces.UserDAO;
import com.chnu.pavel.telephone.model.User;
import com.chnu.pavel.telephone.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TelephoneSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelephoneSystemApplication.class, args);
    }

}
