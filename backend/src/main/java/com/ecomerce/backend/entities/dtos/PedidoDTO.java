package com.ecomerce.backend.entities.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PedidoDTO {

    private List<ProdutoDTO> pedidoCompra;
}
