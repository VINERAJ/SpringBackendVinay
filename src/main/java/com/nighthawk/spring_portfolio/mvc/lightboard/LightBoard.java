package com.nighthawk.spring_portfolio.mvc.lightboard;

import lombok.Data;

@Data  // Annotations to simplify writing code (ie constructors, setters)
public class LightBoard {
    private Light[][] lights;

    public LightBoard(int numRows, int numCols) {
        this.lights = new Light[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                lights[row][col] = new Light();
            }
        }
    }

    public String toString() {  // this adds colors to output
        String outString = "[";
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                // color
                outString += "\033[38;2;" + 
                lights[row][col].getRed() + ";" +
                lights[row][col].getGreen() + ";" +
                lights[row][col].getBlue() + "m" +
                // data
                "{" + 
                "\"row\": " + row + "," +
                "\"column\": " + col + "," +
                "\"light\": " + lights[row][col] + 
                "}," +
                // newline
                "\n" ;
            }
        }
        // remove last comma, newline, add square braket, reset color
        outString = outString.substring(0,outString.length() - 2) + "]" + "\033[m";
		return outString;
    }
    
    static public void main(String[] args) {
        LightBoard lightBoard = new LightBoard(6, 4);
        System.out.println(lightBoard);
    }
}
