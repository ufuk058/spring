package com.beanscope;


import com.beanscope.config.CommentConfig;
import com.beanscope.model.Comment;
import com.beanscope.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {


        //test1();
        //singleton();
        prototype();

    }

    public static void prototype() {
        /*
        to be able to create different objects instances from the container we use
            @Scope(BeanDefinition.SCOPE_PROTOTYPE) over the Service class level(CommentService)
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);
        CommentService cs3 = context.getBean(CommentService.class);

        System.out.println("firstBean = " + cs1);
        System.out.println("secondBean = " + cs2);
        System.out.println("thirdBean = " + cs3);

        if (cs1 == cs2 || cs2 == cs3 ||cs1==cs3) {
            System.out.println("All beans are same, that means all container objects are SAME, Because the " +
                    "default beans type is SINGLETON");

        }else{
            System.out.println("All beans are different as we defined @Scope(BeanDefinition.SCOPE_PROTOTYPE) at the" +
                    "Comment Service class level");

        }
        /*
        firstBean = com.beanscope.service.CommentService@55a561cf
        secondBean = com.beanscope.service.CommentService@3b938003
        thirdBean = com.beanscope.service.CommentService@6f3b5d16
        All beans are different as we defined @Scope(BeanDefinition.SCOPE_PROTOTYPE) at theComment Service class level
         */

    }
        public static void singleton () {
            ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);
            CommentService firstBean = container.getBean(CommentService.class);
            CommentService secondBean = container.getBean(CommentService.class);
            CommentService thirdBean = container.getBean(CommentService.class);

            System.out.println("firstBean = " + firstBean);
            System.out.println("secondBean = " + secondBean);
            System.out.println("thirdBean = " + thirdBean);

            if (firstBean == secondBean && secondBean == thirdBean) {
                System.out.println("All beans are same, that means all container objects are SAME, Because the " +
                        "default beans type is SINGLETON");
            }
        /*
                ---This is singleton scope before adding a prototype scope

            firstBean = com.beanscope.service.CommentService@3ee0fea4
            secondBean = com.beanscope.service.CommentService@3ee0fea4
            thirdBean = com.beanscope.service.CommentService@3ee0fea4
            All beans are same, that means all container objects are SAME, Because the default beans type is SINGLETON
         */


        }
        public static void test1 () {

            ApplicationContext con = new AnnotationConfigApplicationContext(CommentConfig.class);
            Comment comment = new Comment(); //Question: why we did not add the Comment object to the container.
            //Answer: The Comment object will retrieve the data from frontend that's why we can't store it in the container.
            comment.setAuthor("Ufuk");

            comment.setText("This is a very complex structured application. I at least work for a real application" +
                    " to exercise the storing object in the spring context, otherwise will forget it quickly");

            CommentService commentService = con.getBean(CommentService.class);
            commentService.publishComment(comment);


        }


    }

