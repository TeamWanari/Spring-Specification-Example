package com.wanari.specification.example.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String email;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @OneToMany(mappedBy = "user")
    public List<Address> addresses;

}
