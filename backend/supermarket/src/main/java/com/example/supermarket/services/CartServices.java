package com.example.supermarket.services;

import com.example.supermarket.models.CartModel;
import com.example.supermarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServices {
    @Autowired
    CartRepository cartRepository;

    public List<CartModel> getCart(Long userId){
        return cartRepository.FindByUser(userId);
    }

    public String createCart(CartModel cartModel){
        cartRepository.save(cartModel);
        return "Cart created";
    }
}
