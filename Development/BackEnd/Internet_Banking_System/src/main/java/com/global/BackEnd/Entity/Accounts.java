package com.global.BackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    @Id
    private Long accountNumber;
    private Double balance;
    private Long boolNationalId;
    @ManyToOne
    @JoinColumn(name = "national_id")
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy ="sourceAccount",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
//    @JsonIgnore
    private List<Transaction> transaction;

}
