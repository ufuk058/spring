package ioc.bean_annotation.config;

import ioc.bean_annotation.PC;
import ioc.bean_annotation.casefactory.Case;
import ioc.bean_annotation.casefactory.DellCase;
import ioc.bean_annotation.monitorfactory.AcerMonitor;
import ioc.bean_annotation.monitorfactory.Monitor;
import ioc.bean_annotation.monitorfactory.SonyMonitor;
import ioc.bean_annotation.motherboardfactory.AsusMotherboard;
import ioc.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ComputerConfig {

    @Bean(name="sony")
    public Monitor sonyMonitor(){

        return new SonyMonitor("S24BMC","Sony",24);
    }

    @Bean(name="acer")
    public Monitor acerMonitor(){
        return new AcerMonitor("ss123","Acer",30);
    }

    @Bean
    public Motherboard asusMotherBoard(){
        return new AsusMotherboard("MP124","Asus",8,4,"Expert");
    }

    @Bean
    public Case dellCase(){
        return new DellCase("M100","Dell","230");
    }
}
