package com.global.BackEnd.Controller;

import com.global.BackEnd.DTO.AddUserDto;
import com.global.BackEnd.Entity.Accounts;
import com.global.BackEnd.Entity.RoleModel;
import com.global.BackEnd.Entity.User;
import com.global.BackEnd.repository.AccountRepo;
import com.global.BackEnd.repository.UserRepo;
import com.global.BackEnd.service.AccountService;
import com.global.BackEnd.service.RoleService;
import com.global.BackEnd.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
//اشغلو لما ارن الفرونت
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepo accountRepo;
    @GetMapping("")
    public ResponseEntity<?>findAll(){
       return ResponseEntity.ok( userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        return ResponseEntity.ok( userService.findById(id));
    }
    @GetMapping("/role")
    public ResponseEntity<List<User>>findUsersByRolesName(@RequestParam String roleName){
        return userService.findUsersByRolesName(roleName);
    }
    @DeleteMapping("/{adminId}")
    public ResponseEntity<?>deleteById(@PathVariable Long adminId ,@RequestParam Long nationalId){
        return ResponseEntity.ok( userService.deleteUser(adminId,nationalId));
    }
    @PostMapping("/{adminId}")
    public ResponseEntity<?>addUser(@PathVariable Long adminId ,@RequestBody AddUserDto addUserDto){
        if(!userRepo.findById(addUserDto.getNationalId()).isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A User with this NationalId ( "+addUserDto.getNationalId() +" ) already exists.");
        }
        if (userRepo.findByUserName(addUserDto.getUserName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A User with this userName ( "+addUserDto.getUserName() +" ) already exists.");
//            return ResponseEntity.badRequest();
        }
        List<Accounts> accounts=accountRepo.findByBoolNationalId(addUserDto.getNationalId());
        System.out.println(accounts.size());
//        accounts.forEach(accounts1 -> {
//            accounts1.setUser(user);
//            accountRepo.save(accounts1);
//        });
        List<RoleModel> userRoles = new ArrayList<>();
        userRoles.add(roleService.findByName("user"));
        User user=new User(addUserDto.getNationalId(),addUserDto.getFullName(),addUserDto.getUserName(),addUserDto.getEmail(),addUserDto.getPassword(),userRoles,accounts,true,true,true,true);
        user.setAccounts(accounts);
//        accounts.forEach(accounts1 -> {
//            accounts1.setUser(user);
//            accountRepo.save(accounts1);
//        });
        ResponseEntity<?> user1=userService.saveUser(adminId,user);
//                accounts.forEach(accounts1 -> {
//            accounts1.setUser(user);
//            accountRepo.save(accounts1);
//        });
        return ResponseEntity.ok( user1);
    }
}
