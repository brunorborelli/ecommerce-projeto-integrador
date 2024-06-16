package com.ecomerce.backend.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusPedidoEnum {

    AGUARDANDO_PAGAMENTO(1, "Aguardando Pagamento"),
    PAGAMENTO_EFETUADO(2, "Pagamento Efetuado"),
    EM_PREPARACAO(3, "Em Preparação"),
    SAIU_PARA_ENTREGA(4, "Saiu para Entrega"),
    ENTREGA_EM_ANDAMENTO(5, "Entrega em Andamento"),
    ENTREGA_EFETUADA(6, "Entrega Efetuada"),
    CANCELADO(7, "Cancelado");

    private final int id;
    private final String descricao;

}
