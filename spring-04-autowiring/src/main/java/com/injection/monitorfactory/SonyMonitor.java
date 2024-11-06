package com.injection.monitorfactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SonyMonitor extends Monitor{

    public SonyMonitor() {
        super("25 inch","Sony",25);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");
    }

}
