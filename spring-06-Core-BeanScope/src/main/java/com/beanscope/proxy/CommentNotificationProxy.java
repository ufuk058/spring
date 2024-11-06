package com.beanscope.proxy;


import com.beanscope.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
