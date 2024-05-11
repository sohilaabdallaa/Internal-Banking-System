package com.global.BackEnd.service;


import com.global.BackEnd.DTO.AddAccountDto;
import com.global.BackEnd.Entity.Accounts;
import com.global.BackEnd.Entity.User;
import com.global.BackEnd.repository.AccountRepo;
import com.global.BackEnd.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleService roleService;
    public ResponseEntity<List<Accounts>>findAll(){
        return ResponseEntity.ok(accountRepo.findAll());
    }
    public ResponseEntity<Accounts>findById(Long accountNumber){
        if(accountRepo.findById(accountNumber).isEmpty()){
            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(accountRepo.findById(accountNumber).get());
    }
    public ResponseEntity<?>deleteById(Long accountNumber){
        if(accountRepo.findById(accountNumber).isEmpty()){
            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(accountRepo.findById(accountNumber).get().getBalance()>0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't Delete account because there is balance.");
}
        accountRepo.deleteById(accountNumber);
        return ResponseEntity.ok("An Account delete successfully");
    }
    public List<Accounts>getAllAccountByNationalId(Long boolNationalId){

        return accountRepo.findByBoolNationalId(boolNationalId);
    }

    public ResponseEntity<?>saveAccount(AddAccountDto accountDto){
        if(!accountRepo.findById(accountDto.getAccountNumber()).isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("An account with this number ( "+accountDto.getAccountNumber() +" ) already exists.");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(userRepo.findById(accountDto.getNationalId()).isEmpty()){
//            Set<RoleModel> userRoles = new HashSet<>();
//            userRoles.add(roleService.findByName("user"));
//            User user=new User(accountDto.getNationalId(),null,null,null,"55",userRoles,null,true,true,true,true);
//            userService.save(user);
            Accounts account=new Accounts(accountDto.getAccountNumber(),accountDto.getBalance(),accountDto.getNationalId(),null,null);
//            user.getAccounts().add(account);
//            account.setUser(user);
            accountRepo.save(account);
            return ResponseEntity.ok("Account Add Successfully");
        }
        User user=userService.findById(accountDto.getNationalId());
        System.out.println(user.getNationalId());
        Accounts newAccount=new Accounts(accountDto.getAccountNumber(),accountDto.getBalance(),null,null,null);
        newAccount.setUser(user);
//        user.getAccounts().add(newAccount);
        accountRepo.save(newAccount);
//        userService.save(user);
        return ResponseEntity.ok("Account Add Successfully");
    }
}
