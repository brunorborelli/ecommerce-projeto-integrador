package com.ecomerce.backend.entities.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoDTO {
    private Long id;
    private Integer quantity;
}
