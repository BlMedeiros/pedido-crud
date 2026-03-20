package com.weg.pedido.dto.itens;

public record ItemPedidoResponseDto(
        Long id,
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Long idPedido
) {
}
