package com.ufuk.stereotype_annotation.casefactory;

import org.springframework.stereotype.Component;

@Component
public class DellCase extends Case{

    public DellCase(){super("2208","Dell","240");}

    public void pressPowerButton(){
        System.out.println("Power Button Pressed");
    }
}
