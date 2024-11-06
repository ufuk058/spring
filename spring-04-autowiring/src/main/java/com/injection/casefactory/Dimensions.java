package com.injection.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    public Dimensions(){
        this.width=50;
        this.height=10;
        this.depth=10;
    }


}
