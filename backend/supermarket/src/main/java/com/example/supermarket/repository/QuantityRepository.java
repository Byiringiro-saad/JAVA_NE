package com.example.supermarket.repository;

import com.example.supermarket.models.QuantityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepository extends JpaRepository<QuantityModel, Long> {

}
