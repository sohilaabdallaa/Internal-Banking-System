package com.global.BackEnd.Controller;

import com.global.BackEnd.DTO.AddAccountDto;
import com.global.BackEnd.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@NoArgsConstructor
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping()
    public ResponseEntity<?>findAll(){
        return accountService.findAll();
    }
    @GetMapping("/{nationalId}")
    public ResponseEntity<?>findById(@PathVariable Long nationalId){
        return accountService.findById(nationalId);
    }
    @DeleteMapping("/{nationalId}")
    public ResponseEntity<?>deleteById(@PathVariable Long nationalId){
        return accountService.deleteById(nationalId);
    }
    @PostMapping()
    public ResponseEntity<?>saveAccount(@RequestBody AddAccountDto addAccountDto){
        return accountService.saveAccount(addAccountDto);
    }
}
