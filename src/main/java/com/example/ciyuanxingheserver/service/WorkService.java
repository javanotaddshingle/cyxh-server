package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Favorite;
import com.example.ciyuanxingheserver.entity.Work;
import com.example.ciyuanxingheserver.repository.FavoriteRepository;
import com.example.ciyuanxingheserver.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    public Work createWork(Work work) {
        work.setCreatedAt(new Date());
        work.setUpdatedAt(new Date());
        work.setLikes(0);
        work.setViews(0);
        return workRepository.save(work);
    }

    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    public Work getWorkById(Long id) {
        return workRepository.findById(id).orElse(null);
    }

    public void incrementViews(Long id) {
        Work work = workRepository.findById(id).orElse(null);
        if (work != null) {
            work.setViews(work.getViews() + 1);
            workRepository.save(work);
        }
    }

    public List<Work> getWorksByCategory(String category) {
        return workRepository.findByCategory(category);
    }

    public List<Work> getWorksByUserId(Long userId) {
        return workRepository.findByUserId(userId);
    }

    public List<Work> searchWorks(String keyword) {
        return workRepository.findByTitleContaining(keyword);
    }

    public Work updateWork(Work work) {
        work.setUpdatedAt(new Date());
        return workRepository.save(work);
    }

    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }

    public Work likeWork(Long id) {
        Work work = workRepository.findById(id).orElse(null);
        if (work != null) {
            work.setLikes(work.getLikes() + 1);
            workRepository.save(work);
        }
        return work;
    }

    public boolean favoriteWork(Long workId, Long userId) {
        Optional<Favorite> existingFavorite = favoriteRepository.findByUserIdAndWorkId(userId, workId);
        if (existingFavorite.isPresent()) {
            // 取消收藏
            favoriteRepository.deleteByUserIdAndWorkId(userId, workId);
            return false;
        } else {
            // 添加收藏
            Favorite favorite = new Favorite();
            favorite.setUserId(userId);
            favorite.setWorkId(workId);
            favorite.setCreatedAt(new Date());
            favoriteRepository.save(favorite);
            return true;
        }
    }

    public boolean isWorkFavorited(Long workId, Long userId) {
        return favoriteRepository.findByUserIdAndWorkId(userId, workId).isPresent();
    }

    public List<Work> getUserFavoriteWorks(Long userId) {
        List<Favorite> favorites = favoriteRepository.findByUserId(userId);
        List<Work> works = new ArrayList<>();
        for (Favorite favorite : favorites) {
            Work work = workRepository.findById(favorite.getWorkId()).orElse(null);
            if (work != null) {
                works.add(work);
            }
        }
        return works;
    }

    public List<Work> getWorkRanking(String type) {
        if ("views".equals(type)) {
            return workRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "views"))).getContent();
        } else {
            return workRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likes"))).getContent();
        }
    }
}