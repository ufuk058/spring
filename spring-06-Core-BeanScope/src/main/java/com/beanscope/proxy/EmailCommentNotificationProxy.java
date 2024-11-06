package com.beanscope.proxy;


import com.beanscope.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment){
        System.out.println("Sending EMAIL notification for comment: "+comment.getText());
    }
}
