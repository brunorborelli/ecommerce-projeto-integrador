package com.ecomerce.backend.entities.dtos;

import com.ecomerce.backend.enums.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PedidoResponseDto {
    private Integer id;
    private Integer produtoId;
    private Integer quantidade;
    private StatusPedidoEnum statusPedido;
    private Boolean status;
    private LocalDateTime dataHora;
    private LocalDateTime dataHoraUltimaAlteracao;
    private UsuarioDTO usuario;
}
