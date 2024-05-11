package com.global.BackEnd.service;

import com.global.BackEnd.Entity.User;
import com.global.BackEnd.repository.UserRepo;
import com.global.BackEnd.security.AppUserDetail;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<User>findAll(){
        return userRepo.findAll();
    }
    public User findById(Long id){
        return userRepo.findById(id).orElse(null);
    }
   // save new users in DB
    public User save(User entity){
        // encript password
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepo.save(entity);
    }
    // return generic response entity that can hold any type of response body.
    // used to save or update a user entity in the database, with additional logic
    // to check if the user performing the operation has the "admin" role.
    public ResponseEntity<?> saveUser(Long adminId,User entity){
        System.out.println(userRepo.getById(adminId).getRoles().stream().findFirst().get().getName());
        if(!userRepo.getById(adminId).getRoles().stream().findFirst().get().getName().equals("admin")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An account Role with this NationalId ( "+adminId +" ) Not Admin.");
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return ResponseEntity.ok(userRepo.save(entity));
    }
    public ResponseEntity<?> deleteUser(Long adminId,Long nationalId){
        System.out.println(userRepo.getById(adminId).getRoles().stream().findFirst().get().getName());
        if(!userRepo.getById(adminId).getRoles().stream().findFirst().get().getName().equals("admin")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An account Role with this NationalId ( "+adminId +" ) Not Admin.");
        }
        User user=userRepo.findById(nationalId).get();
        if (userRepo.findById(nationalId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An account with this NationalId ( "+user.getNationalId() +" ) Not Found.");
        }

        userRepo.delete(user);
        return ResponseEntity.ok("User Delete successfully");
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(userName);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("This User Not Found With select userName");
        }
//        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), getAuthorities(user.get()));
        return new AppUserDetail(user.get());
    }

    private static List<GrantedAuthority> getAuthorities(User user) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (!user.getRoles().isEmpty()) {
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
        }
        return authorities;
    }
    public ResponseEntity<List<User>>findUsersByRolesName(String Rolename){
        return ResponseEntity.ok( userRepo.findByRolesName(Rolename));
    }
}
