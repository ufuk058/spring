package com.appstructure.proxy;

import com.appstructure.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationProxy{

    public void sendComment(Comment comment){

        System.out.println("Sending PUSH notification for comment: "+comment.getText());
    }
    /*
    Once we add two notification  beans with the @Component annotation we will get below error
    expected single matching bean but found 2: emailCommentNotificationProxy,pushCommentNotificationProxy
    Solution 1: You can add @Primary(class level) annotation for any beans that you want(emailCommentNotificationProxy,pushCommentNotificationProxy)
    Solution 2: you can use @Qualifier("beanName") right before the bean object in the constructor argument
     */
}
