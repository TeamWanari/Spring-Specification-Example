package com.wanari.specification.example.domain;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    public User user;

    @Column
    public Integer zip;

    @Column
    public String street;

    @Column
    public String city;

}
