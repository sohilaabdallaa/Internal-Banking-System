package com.global.BackEnd.Controller;

import com.global.BackEnd.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
//اشغلو لما ارن الفرونت
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@NoArgsConstructor
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public ResponseEntity<?>findAll(){
       return ResponseEntity.ok( roleService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        return ResponseEntity.ok( roleService.findById(id));
    }
}
