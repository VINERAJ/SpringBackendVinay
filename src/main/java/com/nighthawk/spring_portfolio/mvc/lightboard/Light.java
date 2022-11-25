package com.nighthawk.spring_portfolio.mvc.lightboard;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data  // Annotations to simplify writing code (ie constructors, setters)
public class Light {
    boolean on;
    byte red;
    byte green;
    byte blue;
    byte effect;

    /*  ANSI effects
        n	Name	Note
        0	Reset or normal	All attributes off
        1	Bold or increased intensity	As with faint, the color change is a PC (SCO / CGA) invention.[38][better source needed]
        2	Faint, decreased intensity, or dim	May be implemented as a light font weight like bold.[39]
        3	Italic	Not widely supported. Sometimes treated as inverse or blink.[38]
        4	Underline	Style extensions exist for Kitty, VTE, mintty and iTerm2.[40][41]
        5	Slow blink	Sets blinking to less than 150 times per minute
        6	Rapid blink	MS-DOS ANSI.SYS, 150+ per minute; not widely supported
        7	Reverse video or invert	Swap foreground and background colors; inconsistent emulation[42]
        8	Conceal or hide	Not widely supported.
        9	Crossed-out, or strike	Characters legible but marked as if for deletion. Not supported in Terminal.app
     */
    private final Map<Byte, String> EFFECT = new HashMap<>();
    {
        // Map<"separator", not_used>
        EFFECT.put((byte) 0, "Normal");
        EFFECT.put((byte) 1, "Bold");
        EFFECT.put((byte) 2, "Faint");
        EFFECT.put((byte) 3, "Italic");
        EFFECT.put((byte) 4, "Underline");
        EFFECT.put((byte) 5, "Slow Blink");
        EFFECT.put((byte) 6, "Fast Blink");
        EFFECT.put((byte) 7, "Reverse");
        EFFECT.put((byte) 8, "Conceal");
        EFFECT.put((byte) 9, "Crossed_out");
    }

    /* Assign random colors and effects */
    public Light() {
        int maxColor = 255;
        int effect = 9;
        this.red = (byte) (Math.random()*(maxColor+1));
        this.green = (byte) (Math.random()*(maxColor+1));
        this.blue = (byte) (Math.random()*(maxColor+1));
        this.effect = (byte) (Math.random()*(effect+1));
    }

    /* toString output as key/values */
    public String toString() {
        return( "{" + 
            "\"red\": " + red + "," +
            "\"green\": " +  green + "," + 
            "\"blue\": " + blue + "," +
            "\"effect\": " + "\"" + EFFECT.get(effect) + "\"" +
            "}" );
    }
}
