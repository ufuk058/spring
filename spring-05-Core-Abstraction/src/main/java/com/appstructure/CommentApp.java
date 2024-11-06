package com.appstructure;

import com.appstructure.config.CommentConfig;
import com.appstructure.model.Comment;
import com.appstructure.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {
       test1();
    }

    public static void test1(){

        ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);
        Comment comment= new Comment(); //Question: why we did not add the Comment object to the container.
            //Answer: The Comment object will retrieve the data from frontend that's why we can't store it in the container.
        comment.setAuthor("Ufuk");

        comment.setText("This is a very complex structured application. I at least work for a real application" +
                " to exercise the storing object in the spring context, otherwise will forget it quickly");

        CommentService commentService= container.getBean(CommentService.class);
        commentService.publishComment(comment);


    }


}
