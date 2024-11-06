package com.appstructure.repository;

import com.appstructure.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
