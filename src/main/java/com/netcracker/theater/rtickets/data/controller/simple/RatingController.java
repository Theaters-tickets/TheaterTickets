package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.entity.Comment;
import com.netcracker.theater.rtickets.data.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class RatingController {

    private final CommentService commentService;

    public RatingController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public String getComments(Model model) {
        List<Comment> comments = commentService.getAllComments();
        Comment comment = new Comment();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", comment);
        return "comment";
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/comments/";
    }
}

