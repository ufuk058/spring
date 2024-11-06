package com.appstructure.proxy;

import com.appstructure.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
