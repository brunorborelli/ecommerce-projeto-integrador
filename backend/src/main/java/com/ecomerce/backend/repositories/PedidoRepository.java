package com.ecomerce.backend.repositories;

import com.ecomerce.backend.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query(value = "SELECT * FROM pedido WHERE " +
            "(:status IS NULL OR status = :status) AND " +
            "(:statusPedido IS NULL OR status_pedido = :statusPedido)",
            nativeQuery = true)
    List<Pedido> findPedidosByStatusAndStatusPedido(
            @Param("status") Boolean status,
            @Param("statusPedido") Short statusPedido);
}
