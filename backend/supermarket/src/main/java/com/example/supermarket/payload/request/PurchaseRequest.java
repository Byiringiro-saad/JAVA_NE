package com.example.supermarket.payload.request;

import jakarta.validation.constraints.NotBlank;

public class PurchaseRequest {
    @NotBlank
    private Long cartId;

    @NotBlank
    private Long userId;
}