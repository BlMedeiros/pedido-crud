package com.weg.pedido.repository;

import com.weg.pedido.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long> {

    List<ItemPedido> findAllByPedidoId(Long id);

    void deleteAllByPedidoId(Long id);
}
