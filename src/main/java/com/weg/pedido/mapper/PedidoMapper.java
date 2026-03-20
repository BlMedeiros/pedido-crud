package com.weg.pedido.mapper;

import com.weg.pedido.dto.pedido.PedidoRequestDto;
import com.weg.pedido.dto.pedido.PedidoResponseDto;
import com.weg.pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido paraEntidade(PedidoRequestDto pedidoRequestDto) {
        return new Pedido(
                pedidoRequestDto.id(),
                pedidoRequestDto.dataPedido()
        );
    }

    public PedidoResponseDto paraResposta(Pedido pedido) {
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getDataPedido()
        );
    }
}
