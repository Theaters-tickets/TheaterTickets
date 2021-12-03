package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TheatreDAO extends JpaRepository<Theatre, UUID> {
    @Query("select theatre from Theatre theatre where theatre.number = ?1")
    Theatre getByNumber(Long theatreNumber);

    @Query("select case when count(t)> 0 then true else false end from Theatre t where lower(t.name) like lower(:name)")
    boolean isExistByName(String name);
}
