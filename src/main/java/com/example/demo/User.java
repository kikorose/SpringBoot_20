package com.example.demo;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings("ALL")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enable;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id")),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}
