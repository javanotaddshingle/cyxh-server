package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Workshop;
import com.example.ciyuanxingheserver.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkshopService {
    @Autowired
    private WorkshopRepository workshopRepository;

    public Workshop createWorkshop(Workshop workshop) {
        workshop.setCreatedAt(new Date());
        workshop.setUpdatedAt(new Date());
        workshop.setParticipants(0);
        return workshopRepository.save(workshop);
    }

    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    public Workshop getWorkshopById(Long id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public List<Workshop> getWorkshopsByCategory(String category) {
        return workshopRepository.findByCategory(category);
    }

    public List<Workshop> getWorkshopsByUserId(Long userId) {
        return workshopRepository.findByUserId(userId);
    }

    public List<Workshop> searchWorkshops(String keyword) {
        return workshopRepository.findByTitleContaining(keyword);
    }

    public Workshop updateWorkshop(Workshop workshop) {
        workshop.setUpdatedAt(new Date());
        return workshopRepository.save(workshop);
    }

    public void deleteWorkshop(Long id) {
        workshopRepository.deleteById(id);
    }

    public Workshop joinWorkshop(Long id) {
        Workshop workshop = workshopRepository.findById(id).orElse(null);
        if (workshop != null) {
            workshop.setParticipants(workshop.getParticipants() + 1);
            workshopRepository.save(workshop);
        }
        return workshop;
    }
}