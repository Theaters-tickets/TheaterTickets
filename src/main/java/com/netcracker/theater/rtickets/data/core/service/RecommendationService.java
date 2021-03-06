package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Recommendation;
import com.netcracker.theater.rtickets.data.storage.entity.Repertoire;

import java.util.List;
import java.util.UUID;

public interface RecommendationService {

    List<Recommendation> getAllRecommendations();

    void saveRecommendation(Recommendation recommendation);

    Recommendation getRecommendation(UUID id);

    void deleteRecommendation(UUID id);

    Recommendation getRecommendationByName(String name);

    List<Repertoire> getRepertoire(Recommendation recommendation);

    List<String> getAllNames();

    Recommendation getRecommendationBySlug(String name);
}
