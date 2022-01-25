package com.example.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer prodId;
    @Column(nullable = false,unique = true, length = 100)
    String prodName;
    Integer prodPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    Category category;

}
