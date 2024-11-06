package ufuk.loselycoupled;

import ufuk.loselycoupled.casefactory.Case;
import ufuk.loselycoupled.monitorfactory.Monitor;
import ufuk.loselycoupled.motherboardfactory.Motherboard;

public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard){
        this.theCase=theCase;
        this.monitor=monitor;
        this.motherboard=motherboard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){monitor.drawPixelAt();}
}
