package com.weg.pedido.dto.pedido;

import java.time.LocalDateTime;

public record PedidoResponseDto(
        long id,
        LocalDateTime dataPedido
) { }
