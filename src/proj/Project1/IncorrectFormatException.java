/*
Filename: IncorrectFormatException.java
Author: Yael Brown
Date: 9/12/2020
Brief Purpose of the Program: A program that parses, using recursive descent, a GUI
definition language defined in an input file and generates the GUI that it defines.
*/

package proj.Project1;

public class IncorrectFormatException extends RuntimeException {
    public IncorrectFormatException(String msg) {
        super(msg);
    }
}
