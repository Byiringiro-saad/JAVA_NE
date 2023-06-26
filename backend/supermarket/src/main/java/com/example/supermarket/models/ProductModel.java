package com.example.supermarket.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Products")
public class ProductModel {
    @Id
    @GeneratedValue
    private Long code;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String price;

    @Column
    @CreatedDate
    @CreationTimestamp
    private Date in_date;
}
