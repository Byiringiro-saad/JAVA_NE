package com.example.supermarket.services;

import com.example.supermarket.models.*;
import com.example.supermarket.repository.ProductRepository;
import com.example.supermarket.repository.PurchasedRepository;
import com.example.supermarket.repository.QuantityRepository;
import com.example.supermarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PurchasedServices {
    @Autowired
    PurchasedRepository purchasedRepository;

    @Autowired
    QuantityRepository quantityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public List<PurchasedModel> getAllPurchased(Long userID){
        return purchasedRepository.findByUser(userID);
    }

    public  List<PurchasedModel> getAllPurchases(){
        return purchasedRepository.findAll();
    }

    public String createPurchased(CartModel cartModel){

        return "Purchase created";
    }
}
