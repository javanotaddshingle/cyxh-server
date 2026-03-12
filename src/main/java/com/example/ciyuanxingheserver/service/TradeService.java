package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Trade;
import com.example.ciyuanxingheserver.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public Trade createTrade(Trade trade) {
        trade.setCreatedAt(new Date());
        trade.setUpdatedAt(new Date());
        trade.setStatus("active");
        return tradeRepository.save(trade);
    }

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Trade getTradeById(Long id) {
        return tradeRepository.findById(id).orElse(null);
    }

    public List<Trade> getTradesByCategory(String category) {
        return tradeRepository.findByCategory(category);
    }

    public List<Trade> getTradesByUserId(Long userId) {
        return tradeRepository.findByUserId(userId);
    }

    public List<Trade> getTradesByStatus(String status) {
        return tradeRepository.findByStatus(status);
    }

    public List<Trade> searchTrades(String keyword) {
        return tradeRepository.findByTitleContaining(keyword);
    }

    public Trade updateTrade(Trade trade) {
        trade.setUpdatedAt(new Date());
        return tradeRepository.save(trade);
    }

    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }

    public Trade updateTradeStatus(Long id, String status) {
        Trade trade = tradeRepository.findById(id).orElse(null);
        if (trade != null) {
            trade.setStatus(status);
            trade.setUpdatedAt(new Date());
            tradeRepository.save(trade);
        }
        return trade;
    }
}