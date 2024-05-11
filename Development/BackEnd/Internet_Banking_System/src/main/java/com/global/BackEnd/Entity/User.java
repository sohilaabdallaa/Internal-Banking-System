package com.global.BackEnd.Entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
        import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "national_id")

    private Long nationalId;
    private String fullName;
    private String userName;

    @Email
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sec_user_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "national_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OrderColumn(name = "id")
    private List<RoleModel>roles;
    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)

    private List<Accounts> accounts;

    private boolean isEnabled;

    private boolean isCredentialsNonExpired;

    private boolean isAccountNonLocked;

    private boolean isAccountNonExpired;

    public User(Long userId) {
        super();
        this.nationalId=userId;
    }
}
