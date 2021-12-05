package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CommentDAO extends JpaRepository<Comment, UUID> {
    @Query("select c from Comment c where c.userName = ?1 and c.repertoire.id = ?2")
    Comment getUsersComment(String userName, UUID repId);
}
