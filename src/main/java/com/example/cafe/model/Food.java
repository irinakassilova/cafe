package com.example.cafe.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "foods")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String image;

    @Column(length = 450)
    private String description;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Place place;
}

