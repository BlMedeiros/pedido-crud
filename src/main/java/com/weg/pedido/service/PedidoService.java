package com.weg.pedido.service;

import com.weg.pedido.dto.pedido.PedidoRequestDto;
import com.weg.pedido.dto.pedido.PedidoResponseDto;
import com.weg.pedido.mapper.PedidoMapper;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService  {

    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;

    public PedidoResponseDto criarPedido() {
        return pedidoMapper.paraResposta(pedidoRepository.save(new Pedido()));
    }

    public PedidoResponseDto buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .map(pedidoMapper::paraResposta)
                .orElseThrow(() -> new RuntimeException("Pedido não Encontrado!"));
    }

    public List<PedidoResponseDto> buscarTodosOsPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::paraResposta)
                .toList();
    }

    public PedidoResponseDto atualizarPedido(Long id, PedidoRequestDto pedidoRequestDto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não Encontrado"));

        pedido.setId(pedidoRequestDto.id());
        pedido.setDataPedido(pedidoRequestDto.dataPedido());

        return pedidoMapper.paraResposta(pedidoRepository.save(pedido));

    }

    public void deletarPedido(Long id) {
        if(!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não Encontrado");
        }

        pedidoRepository.deleteById(id);
    }
}
