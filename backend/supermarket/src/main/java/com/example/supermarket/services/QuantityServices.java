package com.example.supermarket.services;

import com.example.supermarket.models.QuantityModel;
import com.example.supermarket.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityServices {
    @Autowired
    QuantityRepository quantityRepository;

    public List<QuantityModel> getAllQuantities(){
        return quantityRepository.findAll();
    }

    public String createQuantity(QuantityModel quantityModel){
        quantityRepository.save(quantityModel);
        return "Quantity created";
    }
}
