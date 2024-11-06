package ufuk.loselycoupled.monitorfactory;

public class SonyMonitor extends Monitor{

    public SonyMonitor(String model, String manufacturer,int size){
        super(model, manufacturer,size);
    }

    public void drawPixelAt(){
        System.out.println("Drawing with Sony Monitor!");
    }
}
