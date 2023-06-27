package com.example.supermarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Quantities")
public class QuantityModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "code", insertable=false, updatable=false)
    private ProductModel product;

    @Column
    private Number quantity;

    @Column
    private String operation;

    @Column
    @CreatedDate
    @CreationTimestamp
    private Date date;
}
