package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.Drawing;
import com.example.ciyuanxingheserver.service.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/drawings")
public class DrawingController {
    @Autowired
    private DrawingService drawingService;

    @PostMapping
    public Drawing createDrawing(@RequestBody Drawing drawing) {
        return drawingService.createDrawing(drawing);
    }

    @GetMapping
    public List<Drawing> getAllDrawings() {
        return drawingService.getAllDrawings();
    }

    @GetMapping("/{id}")
    public Drawing getDrawingById(@PathVariable Long id) {
        return drawingService.getDrawingById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Drawing> getDrawingsByUserId(@PathVariable Long userId) {
        return drawingService.getDrawingsByUserId(userId);
    }

    @GetMapping("/category/{category}")
    public List<Drawing> getDrawingsByCategory(@PathVariable String category) {
        return drawingService.getDrawingsByCategory(category);
    }

    @PutMapping("/{id}")
    public Drawing updateDrawing(@PathVariable Long id, @RequestBody Drawing drawing) {
        drawing.setId(id);
        return drawingService.updateDrawing(drawing);
    }

    @DeleteMapping("/{id}")
    public void deleteDrawing(@PathVariable Long id) {
        drawingService.deleteDrawing(id);
    }
}