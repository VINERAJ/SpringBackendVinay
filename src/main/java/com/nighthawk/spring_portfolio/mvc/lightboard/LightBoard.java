package com.nighthawk.spring_portfolio.mvc.lightboard;

import lombok.Data;

@Data  // Annotations to simplify writing code (ie constructors, setters)
public class LightBoard {
    private Light[][] lights;

    /* Initialize LightBoard and Lights */
    public LightBoard(int numRows, int numCols) {
        this.lights = new Light[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                lights[row][col] = new Light();
            }
        }
    }

    /* Output is intended for Terminal, effects added to output */
    public String toTerminal() { 
        String outString = "[";
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // reset
                "\033[m" +
                
                // color
                "\033[38;2;" + 
                lights[row][col].getRed() + ";" +
                lights[row][col].getGreen() + ";" +
                lights[row][col].getBlue() + ";" +
                lights[row][col].getEffect() + "m" +
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

    /* Output is intended for Terminal, effects added to output */
    public String toLightBoard() { 
        String outString = "";
        for (int row = 0; row < lights.length; row++) {
            for (int i = 0; i < 4; i++) {
                for (int col = 0; col < lights[row].length; col++) {
                    for (int j = 0; j < 8; j++)
                        outString += 
                        // reset
                        "\033[m" +
                        
                        // color
                        "\033[48;2;" + 
                        lights[row][col].getRed() + ";" +
                        lights[row][col].getGreen() + ";" +
                        lights[row][col].getBlue() + "m" +
                        // data
                        " " +
                        "\033[m";
                }
                outString += "\n";
            }
        }
        // remove last comma, newline, add square braket, reset color
        outString += "\033[m";
		return outString;
    }

    /* Output is intended for API */
    public String toString() { 
        String outString = "[";
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                outString += 
                // data
                "{" + 
                "\"row\": " + row + "," +
                "\"column\": " + col + "," +
                "\"light\": " + lights[row][col] + 
                "}," ;
            }
        }
        // remove last comma, newline, add square braket, reset color
        outString = outString.substring(0,outString.length() - 1) + "]";
		return outString;
    }
    
    static public void main(String[] args) {
        // create and display LightBoard
        LightBoard lightBoard = new LightBoard(8, 8);
        System.out.println(lightBoard);
        System.out.println(lightBoard.toTerminal());
        System.out.println(lightBoard.toLightBoard());

    }
}
