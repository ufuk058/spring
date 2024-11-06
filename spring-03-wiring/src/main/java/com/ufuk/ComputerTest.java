package com.ufuk;


import com.ufuk.casefactory.Case;
import com.ufuk.config.PcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        myTest();


    }

    public static void myTest(){
        ApplicationContext container= new AnnotationConfigApplicationContext(PcConfig.class);

        Case theCase= container.getBean(Case.class);
        System.out.println("theCase.getDimensions().getDepth() = " + theCase.getDimensions().getDepth());
    }
    public static void test1(){
        ApplicationContext container = new AnnotationConfigApplicationContext(PcConfig.class);

        Case theCase = container.getBean(Case.class);

        System.out.println("theCase.getDimensions().getDepth() = " + theCase.getDimensions().getDepth());
    }
}
