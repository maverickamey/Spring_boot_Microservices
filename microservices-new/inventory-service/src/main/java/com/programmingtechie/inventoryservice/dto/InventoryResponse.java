package com.programmingtechie.inventoryservice.dto;


// this is to take care of now we are seraching in the List of SKUCODES
// for that we are hoing with this approach

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
}
