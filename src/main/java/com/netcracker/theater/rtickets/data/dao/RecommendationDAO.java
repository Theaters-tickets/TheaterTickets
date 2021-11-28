package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.Recommendation;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RecommendationDAO extends JpaRepository<Recommendation, UUID> {
    @Query("select rec from Recommendation rec where rec.ruName = ?1")
    Recommendation getByName(String name);

    @Query("select rec from Recommendation rec where rec.name = ?1")
    Recommendation getBySlug(String name);

    @Query(value = "select distinct rep from Repertoire rep " +
            "join rep.categories cat " +
            "join cat.recommendation rec " +
            "where rec = ?1")
    List<Repertoire> getRepertoires(Recommendation recommendation);

    @Query("select distinct rec.ruName from Recommendation rec")
    List<String> getAllNames();
}
