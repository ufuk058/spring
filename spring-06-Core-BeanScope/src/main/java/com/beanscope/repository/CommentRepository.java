package com.beanscope.repository;


import com.beanscope.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
