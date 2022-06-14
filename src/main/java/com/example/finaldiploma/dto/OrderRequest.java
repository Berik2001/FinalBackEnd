package com.example.finaldiploma.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private Long id;

    private String productName;

    private String startDate;

    private String endDate;

    private Long totalPrice;

    private String username;

    private String phone;


}
