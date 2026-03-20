package com.weg.pedido.dto;

import java.time.LocalDateTime;

public record PedidoResponseDto(
        long id,
        LocalDateTime dataPedido
) { }
