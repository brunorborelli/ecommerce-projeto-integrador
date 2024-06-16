package com.ecomerce.backend.controllers;

import com.ecomerce.backend.entities.dtos.PedidoDTO;
import com.ecomerce.backend.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<Void> cadastrarPedido(@RequestBody PedidoDTO pedidoDTO, @RequestHeader("Authorization") String authHeader) {
        pedidoService.cadastrarPedido(pedidoDTO, authHeader);
        return ResponseEntity.ok().build();
    }
}
