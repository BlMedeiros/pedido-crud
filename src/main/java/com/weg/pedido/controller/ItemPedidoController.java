package com.weg.pedido.controller;

import com.weg.pedido.dto.itens.ItemPedidoResponseDto;
import com.weg.pedido.dto.itens.ItemPedidoResquestDto;
import com.weg.pedido.service.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;


    @PostMapping
    public ItemPedidoResponseDto criarItemPedido(@RequestBody @Valid ItemPedidoResquestDto resquestDto) {
        return itemPedidoService.criarItemPedido(resquestDto);
    }

    @GetMapping("/{id}")
    public ItemPedidoResponseDto buscarPedidoPorId(@PathVariable Long id) {
        return itemPedidoService.buscarItemPorId(id);
    }

    @GetMapping("/pedido/{id}")
    public List<ItemPedidoResponseDto> buscarItemPorPedidoId(@PathVariable Long id) {
        return itemPedidoService.buscarItemPorPedidoId(id);
    }

    @GetMapping
    public List<ItemPedidoResponseDto> buscarTodosOsItens() {
        return itemPedidoService.buscarTodosOsItens();
    }

    @PutMapping("/{id}")
    public ItemPedidoResponseDto atualizarItem(@PathVariable Long id, @RequestBody @Valid ItemPedidoResquestDto resquestDto) {
        return itemPedidoService.atualizarItem(id,resquestDto);
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Long id) {
        itemPedidoService.deletarItem(id);
    }

    @DeleteMapping("/pedido/{id}")
    public void deletarTodosItensPedido(@PathVariable Long id) {
        itemPedidoService.deletarTodosItensPedido(id);
    }
}
