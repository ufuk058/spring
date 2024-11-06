package com.ufuk.stereotype_annotation;

import com.ufuk.stereotype_annotation.casefactory.Case;
import com.ufuk.stereotype_annotation.monitorfactory.Monitor;
import com.ufuk.stereotype_annotation.motherboardfactory.Motherboard;
import lombok.Getter;

@Getter
public class PC {
    private Case theCase;
    private Monitor theMonitor;
    private Motherboard theMotherboard;

    public PC(Case theCase, Monitor theMonitor, Motherboard theMotherboard){
        this.theCase=theCase;
        this.theMonitor=theMonitor;
        this.theMotherboard=theMotherboard;
    }
    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    public void drawLogo(){
        theMonitor.drawPixelAt();
    }
}
