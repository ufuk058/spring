package ioc.bean_annotation;

import ioc.bean_annotation.carFactory.Car;
import ioc.bean_annotation.casefactory.Case;
import ioc.bean_annotation.config.CarConfig;
import ioc.bean_annotation.config.ComputerConfig;
import ioc.bean_annotation.config.TaskConfig;
import ioc.bean_annotation.monitorfactory.Monitor;
import ioc.bean_annotation.monitorfactory.SonyMonitor;
import ioc.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        //solution1MultipleBeans();
        //solution2MultipleBeans();
        //solution3MultipleBeans();
        solution4PrimaryAnnotation();




    }

    public static void solution4PrimaryAnnotation(){

        //Before adding primary annotation
        //No qualifying bean of type 'ioc.bean_annotation.carFactory.Car' available:
        //After adding primaryAnnotation it calls the primary annotated object
        ApplicationContext container= new AnnotationConfigApplicationContext(CarConfig.class);
        Car c = container.getBean(Car.class);
        c.displayMake(); //My car is: Honda
    }

    public static void solution3MultipleBeans(){
        //Providing a name or the specific bean and use it for calling that bean
        ApplicationContext container= new AnnotationConfigApplicationContext(ComputerConfig.class, TaskConfig.class);
        Monitor sonyMonitor=container.getBean("sony",Monitor.class); //specify the bean class
        Case theCase= container.getBean(Case.class);
        Motherboard motherboard= container.getBean(Motherboard.class);
        PC myPC3= new PC(theCase,sonyMonitor,motherboard);
        myPC3.powerUp();

    }

    public static void solution2MultipleBeans(){
        ApplicationContext container= new AnnotationConfigApplicationContext(ComputerConfig.class, TaskConfig.class);
        Monitor sonyMonitor=container.getBean("sonyMonitor",Monitor.class); //specify the bean class
        Case theCase= container.getBean(Case.class);
        Motherboard motherboard= container.getBean(Motherboard.class);
        PC myPC3= new PC(theCase,sonyMonitor,motherboard);
        myPC3.powerUp();
    }
    public static void solution1MultipleBeans(){
        ApplicationContext container= new AnnotationConfigApplicationContext(ComputerConfig.class, TaskConfig.class);
        Monitor sonyMonitor=container.getBean(SonyMonitor.class); //specify the bean class
        Case theCase= container.getBean(Case.class);
        Motherboard motherboard= container.getBean(Motherboard.class);
        //System.out.println("monitor1 = " + monitor1);
        PC myPc2= new PC(theCase,sonyMonitor,motherboard);
        myPc2.powerUp();
    }

    public static void callingBeans(){
        ApplicationContext container1=new AnnotationConfigApplicationContext();
        //Now this container object is empty, in order to add my class objects to this container ,I need to create Config
        //Then introduce the config class to the container below
        ApplicationContext container= new AnnotationConfigApplicationContext(ComputerConfig.class, TaskConfig.class);
        //Calling the object over container
        Monitor monitor= container.getBean("acerMonitor",Monitor.class);
        Case theCase= container.getBean(Case.class);
        Motherboard motherboard= container.getBean(Motherboard.class);

        PC myPc= new PC(theCase,monitor,motherboard);
        myPc.powerUp();

        String myString =container.getBean(String.class);
        System.out.println("myString = " + myString);
        Integer myInteger= container.getBean(Integer.class);
        System.out.println("myInteger = " + myInteger);

        ApplicationContext carContainer=new  AnnotationConfigApplicationContext(Car.class);
        Car car = carContainer.getBean(Car.class);
        car.setMake("Honda");
        car.displayMake();
    }
}
