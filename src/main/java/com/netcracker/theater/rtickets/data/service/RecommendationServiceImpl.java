package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.RecommendationDAO;
import com.netcracker.theater.rtickets.data.entity.Recommendation;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private RecommendationDAO recommendationDAO;

    @Override
    @Transactional
    public List<Recommendation> getAllRecommendations() { return recommendationDAO.findAll(); };

    @Override
    @Transactional
    public void saveRecommendation(Recommendation recommendation) { recommendationDAO.save(recommendation); };

    @Override
    @Transactional
    public Recommendation getRecommendation(UUID id) { return recommendationDAO.findById(id).get(); };

    @Override
    @Transactional
    public void deleteRecommendation(UUID id) { recommendationDAO.deleteById(id); }

    @Override
    @Transactional
    public Recommendation getRecommendationByName(String name) { return recommendationDAO.getByName(name); }

    @Override
    @Transactional
    public List<Repertoire> getRepertoire(Recommendation recommendation) { return recommendationDAO.getRepertoires(recommendation); }
}
