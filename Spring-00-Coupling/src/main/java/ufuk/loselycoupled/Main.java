package ufuk.loselycoupled;

import ufuk.loselycoupled.casefactory.Case;
import ufuk.loselycoupled.casefactory.DellCase;
import ufuk.loselycoupled.monitorfactory.AcerMonitor;
import ufuk.loselycoupled.monitorfactory.Monitor;
import ufuk.loselycoupled.motherboardfactory.AsusMotherboard;
import ufuk.loselycoupled.motherboardfactory.Motherboard;

public class Main {
    public static void main(String[] args) {
        Monitor monitor= new AcerMonitor("27inch","Acer",27);
        Case theCase= new DellCase("220B","Dell","240");
        Motherboard theMotherboard =new AsusMotherboard("BJ-200","Asus",4,6,"v2.44");


        PC myPc= new PC(theCase,monitor,theMotherboard);
        myPc.powerUp();
    }
}
