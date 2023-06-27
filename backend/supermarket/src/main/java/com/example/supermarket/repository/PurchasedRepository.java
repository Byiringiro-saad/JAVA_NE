package com.example.supermarket.repository;

import com.example.supermarket.models.PurchasedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedRepository extends JpaRepository<PurchasedModel, Long> {
    @Query("SELECT p FROM PurchasedModel p WHERE p.userId = :userId")
    List<PurchasedModel> findByUser(Long userId);
}
