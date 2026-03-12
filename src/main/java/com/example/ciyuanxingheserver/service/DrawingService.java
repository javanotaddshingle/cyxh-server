package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Drawing;
import com.example.ciyuanxingheserver.repository.DrawingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DrawingService {
    @Autowired
    private DrawingRepository drawingRepository;

    public Drawing createDrawing(Drawing drawing) {
        drawing.setCreatedAt(new Date());
        drawing.setUpdatedAt(new Date());
        return drawingRepository.save(drawing);
    }

    public List<Drawing> getAllDrawings() {
        return drawingRepository.findAll();
    }

    public Drawing getDrawingById(Long id) {
        return drawingRepository.findById(id).orElse(null);
    }

    public List<Drawing> getDrawingsByUserId(Long userId) {
        return drawingRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public List<Drawing> getDrawingsByCategory(String category) {
        return drawingRepository.findByCategoryOrderByCreatedAtDesc(category);
    }

    public Drawing updateDrawing(Drawing drawing) {
        drawing.setUpdatedAt(new Date());
        return drawingRepository.save(drawing);
    }

    public void deleteDrawing(Long id) {
        drawingRepository.deleteById(id);
    }
}