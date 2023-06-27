package com.example.supermarket.models;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.List;

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

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "code", insertable=false, updatable=false)
    private ProductModel product;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserModel user;

    @Column
    private Number total;

    @Column
    @CreatedDate
    @CreationTimestamp
    private Date date;

}
