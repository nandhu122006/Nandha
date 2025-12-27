package com.examly.springapp.service;

import com.examly.springapp.model.Comment;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class CommentServiceImpl implements CommentService {
    
    private List<Comment> comments = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Comment addComment(Comment comment) {
        comment.setCommentId(nextId++);
        comments.add(comment);
        return comment;
    }

    @Override
    public List<Comment> getAllComments() {
        return comments;
    }

    @Override
    public Comment getCommentById(Long id) {
        return comments.stream()
                .filter(comment -> comment.getCommentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Comment existing = getCommentById(id);
        if (existing != null) {
            existing.setContent(comment.getContent());
            existing.setIsInternal(comment.getIsInternal());
            return existing;
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        comments.removeIf(comment -> comment.getCommentId().equals(id));
    }
}