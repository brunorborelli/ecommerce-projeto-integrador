package com.ecomerce.backend.services;

import com.ecomerce.backend.entities.Pedido;
import com.ecomerce.backend.entities.Usuario;
import com.ecomerce.backend.entities.dtos.PedidoDTO;
import com.ecomerce.backend.repositories.PedidoRepository;
import com.ecomerce.backend.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final TokenService tokenService;

    private final UsuarioService usuarioService;

    private final ProductService productService;

    public void cadastrarPedido(PedidoDTO pedidoDTO, String authHeader ) {
        validarEstoque(pedidoDTO);
        String token = authHeader.replace("Bearer ", "");
        String email = tokenService.validateToken(token);
        Usuario user = usuarioService.findByEmail(email);
        List<Pedido> pedidos = pedidoDTO.getPedidoCompra().stream()
                .map(produtoDTO -> new Pedido(null, produtoDTO.getId().intValue(), produtoDTO.getQuantity(), user))
                .collect(Collectors.toList());

        pedidoRepository.saveAll(pedidos);
    }

    private void validarEstoque(PedidoDTO pedidoDTO) {
        pedidoDTO.getPedidoCompra().forEach(produtoDTO ->
                productService.removerEstoque(produtoDTO.getId(), produtoDTO.getQuantity())
        );
    }


}
