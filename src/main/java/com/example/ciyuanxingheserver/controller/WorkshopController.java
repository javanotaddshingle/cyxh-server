package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.Workshop;
import com.example.ciyuanxingheserver.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
public class WorkshopController {
    @Autowired
    private WorkshopService workshopService;

    @PostMapping
    public Workshop createWorkshop(@RequestBody Workshop workshop) {
        return workshopService.createWorkshop(workshop);
    }

    @GetMapping
    public List<Workshop> getAllWorkshops() {
        return workshopService.getAllWorkshops();
    }

    @GetMapping("/{id}")
    public Workshop getWorkshopById(@PathVariable Long id) {
        return workshopService.getWorkshopById(id);
    }

    @GetMapping("/category/{category}")
    public List<Workshop> getWorkshopsByCategory(@PathVariable String category) {
        return workshopService.getWorkshopsByCategory(category);
    }

    @GetMapping("/user/{userId}")
    public List<Workshop> getWorkshopsByUserId(@PathVariable Long userId) {
        return workshopService.getWorkshopsByUserId(userId);
    }

    @GetMapping("/search/{keyword}")
    public List<Workshop> searchWorkshops(@PathVariable String keyword) {
        return workshopService.searchWorkshops(keyword);
    }

    @PutMapping("/{id}")
    public Workshop updateWorkshop(@PathVariable Long id, @RequestBody Workshop workshop) {
        workshop.setId(id);
        return workshopService.updateWorkshop(workshop);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkshop(@PathVariable Long id) {
        workshopService.deleteWorkshop(id);
    }

    @PostMapping("/{id}/join")
    public Workshop joinWorkshop(@PathVariable Long id) {
        return workshopService.joinWorkshop(id);
    }
}