package com.example.supermarket.repository;

import com.example.supermarket.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long> {

    @Query("SELECT u FROM CartModel u WHERE u.userId = :userId")
    List<CartModel> FindByUser(Long userId);
}
