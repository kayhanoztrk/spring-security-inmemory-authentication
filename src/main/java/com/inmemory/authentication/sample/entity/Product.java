package com.inmemory.authentication.sample.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TT_PRODUCT")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
}
