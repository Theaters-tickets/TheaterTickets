package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> getAllComments();

    void saveComment(Comment genre);

    Comment getComment(UUID id);

    void deleteComment(UUID id);

    Comment getUsersComment(String userName, UUID repId);

}
