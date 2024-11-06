package com.ufuk.config;

import com.ufuk.casefactory.Case;
import com.ufuk.casefactory.DellCase;
import com.ufuk.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    /*
    Second way of wiring:
    Auto wiring
     */
    @Bean
    public Dimensions dimensions(){

        return new Dimensions(50,10,10);
    }
    @Bean
    public Case dellCase(Dimensions dimensions){

        return new DellCase("220-B","Dell","240",dimensions);
    }

    /*

    This is the first way of wiring Beans
    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }
    @Bean
    public Case caseDell(){
        return new DellCase("220B","Dell","240",dimensions());
    }

     */
}
