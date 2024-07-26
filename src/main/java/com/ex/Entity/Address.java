package com.ex.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "pin_code")
    private String pinCode;

    private String state;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private School school;



}