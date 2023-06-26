package com.example.supermarket.services;

import com.example.supermarket.models.PurchasedModel;
import com.example.supermarket.models.QuantityModel;
import com.example.supermarket.repository.PurchasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasedServices {
    @Autowired
    PurchasedRepository purchasedRepository;

    public List<PurchasedModel> getAllPurchased(Long userID){
        return purchasedRepository.findPurchasedModelByUser(userID);
    }

    public String createPurchased(PurchasedModel purchasedModel){
        purchasedRepository.save(purchasedModel);
        return "Purchase created";
    }
}
