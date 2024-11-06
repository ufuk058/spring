package com.injection;



import com.injection.casefactory.Case;
import com.injection.config.PcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        myTest();


    }

    public static void myTest(){
        ApplicationContext contaioner= new AnnotationConfigApplicationContext(PcConfig.class);

        PC myPc= contaioner.getBean(PC.class);
        myPc.powerUp();
        System.out.println(myPc.getTheCase().getDimensions().getDepth());

    }

}
