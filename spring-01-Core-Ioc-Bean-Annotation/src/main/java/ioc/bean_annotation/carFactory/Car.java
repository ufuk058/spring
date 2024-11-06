package ioc.bean_annotation.carFactory;

public class Car {

    private String brand;

    public void setMake(String brand){
        this.brand=brand;
    }

    public void displayMake(){
        System.out.println("My car is: "+brand);
    }
}
