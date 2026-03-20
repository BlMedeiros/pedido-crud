package com.weg.pedido.mapper;

import com.weg.pedido.dto.itens.ItemPedidoResponseDto;
import com.weg.pedido.dto.itens.ItemPedidoResquestDto;
import com.weg.pedido.model.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    public ItemPedido paraEntidade(ItemPedidoResquestDto itemPedidoResquestDto) {
        return new ItemPedido(
                itemPedidoResquestDto.nomeProduto(),
                itemPedidoResquestDto.quantidade(),
                itemPedidoResquestDto.precoUnitario()
                );
    }

    public ItemPedidoResponseDto paraResposta(ItemPedido itemPedido) {
        return new ItemPedidoResponseDto(
                itemPedido.getId(),
                itemPedido.getNomeProduto(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario(),
                itemPedido.getPedido().getId()
        );
    }
}
