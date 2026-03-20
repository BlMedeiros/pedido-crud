package com.weg.pedido.controller;

import com.weg.pedido.dto.pedido.PedidoRequestDto;
import com.weg.pedido.dto.pedido.PedidoResponseDto;
import com.weg.pedido.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public PedidoResponseDto criarPedido() {
        return pedidoService.criarPedido();
    }

    @GetMapping("/{id}")
    public PedidoResponseDto buscarPedidoPorId(@PathVariable Long id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    @GetMapping
    public List<PedidoResponseDto> buscarTodosOsPedidos() {
        return pedidoService.buscarTodosOsPedidos();
    }

    @PutMapping("/{id}")
    public PedidoResponseDto atualizarPedido(@PathVariable Long id, @RequestBody @Valid PedidoRequestDto pedidoRequestDto) {
        return pedidoService.atualizarPedido(id,pedidoRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }
}
