package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PictureDAO extends JpaRepository<Picture, UUID> {
}
