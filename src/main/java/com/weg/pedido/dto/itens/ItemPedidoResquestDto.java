package com.weg.pedido.dto.itens;

public record ItemPedidoResquestDto(
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Long idPedido
) { }
