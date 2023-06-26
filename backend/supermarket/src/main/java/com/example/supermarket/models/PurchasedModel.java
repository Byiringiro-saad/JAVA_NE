package com.example.supermarket.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Purchased")
public class PurchasedModel {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_code")
    private ProductModel product;

    @OneToOne(cascade = CascadeType.ALL)
    private QuantityModel quantity;

    @Column
    private Long user;

    @Column
    private Number total;

    @Column
    @CreatedDate
    @CreationTimestamp
    private Date date;
}
