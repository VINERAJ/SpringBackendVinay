package com.nighthawk.spring_portfolio.mvc.lightboard;

import lombok.Data;

@Data  // Annotations to simplify writing code (ie constructors, setters)
public class Light {
    boolean on;
    short red;
    short green;
    short blue;
    short luminisity;

    public Light() {
        int maxColor = 255;
        this.red = (short) (Math.random()*(maxColor+1));
        this.green = (short) (Math.random()*(maxColor+1));
        this.blue = (short) (Math.random()*(maxColor+1));
        this.luminisity = (short) (Math.random()*(maxColor+1));
    }

    public String toString() {
        return( "(" + red + "," + green + "," + blue + "," + luminisity + ")" );
    }
}
