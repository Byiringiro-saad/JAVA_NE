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
@Setter
@Getter
@Entity
@Table(name = "Cart")
public class CartModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long product;

    @Column
    private Long user;

    @Column
    private Number quantity;

    @Column
    @CreatedDate
    @CreationTimestamp
    private Date date;
}
