package com.global.BackEnd.config;

import com.global.BackEnd.Entity.RoleModel;
import com.global.BackEnd.Entity.User;
import com.global.BackEnd.service.RoleService;
import com.global.BackEnd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {
    private final UserService userService;

    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {


        if (roleService.findAll().isEmpty()) {
            roleService.save(new RoleModel(null, "admin"));
            roleService.save(new RoleModel(null, "user"));
        }


        if (userService.findAll().isEmpty()) {

            List<RoleModel> adminRoles = new ArrayList<>();
            adminRoles.add(roleService.findByName("admin"));
            List<RoleModel> userRoles = new ArrayList<>();
            userRoles.add(roleService.findByName("user"));
            userService.save(new User(30007521533384L, "nour nour","Norhan2001@", "nour@gmail.com", "Norhan2001",adminRoles,null,true,true,true,true));

            userService.save(new User(30007521533385L, "Ali","AliMohamed12@", "ali@gmail.com", "Norhan2001",adminRoles,null,true,true,true,true));

            userService.save(new User(30007521533377L, "Shrook","Zein8080@", "srouk7007@gmail.com", "Norhan2001",userRoles,null,true,true,true,true));
            userService.save(new User(37007521533384L, "Maha","Gaber5050@", "Maha20@gmail.com", "Norhan2001",userRoles,null,true,true,true,true));
            userService.save(new User(30007521533484L, "Noha","Zeinnn8070@", "Noha@gmail.com", "Norhan2001",userRoles,null,true,true,true,true));
            userService.save(new User(30447521533384L, "Mohamed","Maher774@", "mohamed20@gmail.com", "Norhan2001",userRoles,null,true,true,true,true));
        }

    }
}
