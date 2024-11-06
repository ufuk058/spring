package com.ufuk.stereotype_annotation;

import com.ufuk.stereotype_annotation.casefactory.Case;
import com.ufuk.stereotype_annotation.config.PcConfig;
import com.ufuk.stereotype_annotation.monitorfactory.Monitor;
import com.ufuk.stereotype_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

        test1();
    }


    public static  void test1(){
        ApplicationContext container= new AnnotationConfigApplicationContext(PcConfig.class);
        Monitor monitor = container.getBean(Monitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard motherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(theCase,monitor,motherboard);
        myPc.powerUp();

    }

}
