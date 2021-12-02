package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.CommentDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    @Transactional
    public List<Comment> getAllComments() { return commentDAO.findAll(); }

    @Override
    @Transactional
    public void saveComment(Comment comment) { commentDAO.save(comment); }

    @Override
    @Transactional
    public Comment getComment(UUID id) { return commentDAO.findById(id).get(); }

    @Override
    @Transactional
    public void deleteComment(UUID id) { commentDAO.deleteById(id); }

}
