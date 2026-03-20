package com.weg.pedido.dto;

import java.time.LocalDateTime;

public record PedidoRequestDto(
        long id,
        LocalDateTime dataPedido
) { }
