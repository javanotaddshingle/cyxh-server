package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.Trade;
import com.example.ciyuanxingheserver.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade) {
        return tradeService.createTrade(trade);
    }

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id) {
        return tradeService.getTradeById(id);
    }

    @GetMapping("/category/{category}")
    public List<Trade> getTradesByCategory(@PathVariable String category) {
        return tradeService.getTradesByCategory(category);
    }

    @GetMapping("/user/{userId}")
    public List<Trade> getTradesByUserId(@PathVariable Long userId) {
        return tradeService.getTradesByUserId(userId);
    }

    @GetMapping("/status/{status}")
    public List<Trade> getTradesByStatus(@PathVariable String status) {
        return tradeService.getTradesByStatus(status);
    }

    @GetMapping("/search/{keyword}")
    public List<Trade> searchTrades(@PathVariable String keyword) {
        return tradeService.searchTrades(keyword);
    }

    @PutMapping("/{id}")
    public Trade updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
        trade.setId(id);
        return tradeService.updateTrade(trade);
    }

    @DeleteMapping("/{id}")
    public void deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
    }

    @PutMapping("/{id}/status")
    public Trade updateTradeStatus(@PathVariable Long id, @RequestParam String status) {
        return tradeService.updateTradeStatus(id, status);
    }
}