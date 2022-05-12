package com.example.cafe.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Table(name = "places")
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String description;

    @Size(min = 1, max = 128)
    private String image;

    @OneToOne(fetch = FetchType.LAZY)
    private Basket basket;
}

