package com.injection.config;

import com.injection.casefactory.Case;
import com.injection.casefactory.DellCase;
import com.injection.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {


    @Bean
    public Dimensions dimensions(){

        return new Dimensions(50,10,10);
    }
    @Bean
    public Case dellCase(Dimensions dimensions){

        return new DellCase("220-B","Dell","240",dimensions);
    }


}
