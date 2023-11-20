package com.programmingtechie.orderservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtoList;



}
