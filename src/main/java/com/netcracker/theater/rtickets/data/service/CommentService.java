package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> getAllComments();

    void saveComment(Comment genre);

    Comment getComment(UUID id);

    void deleteComment(UUID id);
}
