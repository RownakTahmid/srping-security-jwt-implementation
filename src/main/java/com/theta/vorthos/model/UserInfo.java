package com.theta.vorthos.model;

import com.theta.vorthos.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseEntity{
    private String name;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING) private Set<Roles> roles;
    @OneToMany private List<Article> articles;
}
