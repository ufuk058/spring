package com.beanscope.service;


import com.beanscope.model.Comment;
import com.beanscope.proxy.CommentNotificationProxy;
import com.beanscope.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    /*
    We have two different ways to inject(connect) to the Spring context
    1- @Autowired annotations need to be added all variables
    2- Creating a constructor(either with @Autowired annotation or not) that has all the variable as an argument
     */
    public CommentService(CommentRepository commentRepository,  @Qualifier("PUSH"/*EMAIL*/) CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        //Save into the db
        //send an email
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }
    /*
    What are the classes or interfaces we need to add component
    What is th formula we need to decide
    --We need to add the object to the spring container if it either has a dependency
      we need to inject from the context or if it is a dependency itself.

     1- For example in Current CommentService class
       It has a relationship with the CommentRepository and CommentNotificationProxy interfaces, so it has a dependency
       And if the class is a dependency itself like CommentRepository and CommentNotificationProxy classes

     2-BUT THEY ARE BOTH INTERFACE AND NO NEED TO ADD COMPONENT THEM, INSTEAD ADD COMPONENT WHERE THOSE INTERFACES IMPLEMENTED
       are the dependency itself as their object created in this class

     3-And we need to add Component annotation tho this class as it has a dependencies(CommentRepository and CommentNotificationProxy)

     4- Then we need to create a config class with the @Configuration and @ComponentScan(basePackages="com.structure")

      if the class object is used as a parameter, it is not a dependency so no need to add component

     */
}
