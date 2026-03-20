package com.weg.pedido.service;

import com.weg.pedido.dto.itens.ItemPedidoResponseDto;
import com.weg.pedido.dto.itens.ItemPedidoResquestDto;
import com.weg.pedido.mapper.ItemPedidoMapper;
import com.weg.pedido.model.ItemPedido;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repository.ItemPedidoRepository;
import com.weg.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoMapper itemPedidoMapper;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;

    public ItemPedidoResponseDto criarItemPedido(ItemPedidoResquestDto resquestDto) {

        Pedido pedido = pedidoRepository.findById(resquestDto.idPedido())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        ItemPedido itemPedido = itemPedidoMapper.paraEntidade(resquestDto);

        itemPedido.setPedido(pedido);

        return itemPedidoMapper.paraResposta(itemPedidoRepository.save(itemPedido));
    }

    public ItemPedidoResponseDto buscarItemPorId(Long id) {
        return itemPedidoRepository.findById(id)
                .map(itemPedidoMapper::paraResposta)
                .orElseThrow(() -> new RuntimeException("Item do pedido não encontrado"));
    }

    public List<ItemPedidoResponseDto> buscarItemPorPedidoId(Long id) {
        return itemPedidoRepository.findAllByPedidoId(id)
                .stream()
                .map(itemPedidoMapper::paraResposta)
                .toList();
    }

    public List<ItemPedidoResponseDto> buscarTodosOsItens() {
        return itemPedidoRepository.findAll()
                .stream()
                .map(itemPedidoMapper::paraResposta)
                .toList();
    }

    public ItemPedidoResponseDto atualizarItem(Long id, ItemPedidoResquestDto resquestDto) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do pedido não encontrado"));

        Pedido pedido = pedidoRepository.findById(resquestDto.idPedido())
                        .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        itemPedido.setNomeProduto(resquestDto.nomeProduto());
        itemPedido.setQuantidade(resquestDto.quantidade());
        itemPedido.setPrecoUnitario(resquestDto.precoUnitario());
        itemPedido.setPedido(pedido);

        return itemPedidoMapper.paraResposta(itemPedidoRepository.save(itemPedido));
    }

    public void deletarItem(Long id) {
        if(!itemPedidoRepository.existsById(id)) {
            throw new RuntimeException("Item do pedido não foi encontrado");
        }

        itemPedidoRepository.deleteById(id);
    }

    public void deletarTodosItensPedido(Long id) {
        if(!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não foi encontrado");
        }

        itemPedidoRepository.deleteAllByPedidoId(id);
    }
}
