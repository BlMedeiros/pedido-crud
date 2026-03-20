package com.weg.pedido.dto.pedido;

import java.time.LocalDateTime;

public record PedidoRequestDto(
        long id,
        LocalDateTime dataPedido
) { }
