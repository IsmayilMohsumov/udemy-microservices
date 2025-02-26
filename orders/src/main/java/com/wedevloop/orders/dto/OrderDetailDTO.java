package com.wedevloop.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDetailDTO {
    private String customerName;
    private String menuName;
    private LocalDateTime orderDate;
}
