/*
Filename: Project1.java
Author: Yael Brown
Date: 9/12/2020
Brief Purpose of the Program: A program that parses, using recursive descent, a GUI
definition language defined in an input file and generates the GUI that it defines.
*/

package proj.Project1;

import javax.swing.*;
import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.Scanner;

public class Project1 {

    public static ArrayList<String> readFile() throws IncorrectFormatException {
        ArrayList<String> out = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        Integer res = chooser.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                if (f.isFile()) {
                    Scanner myReader = new Scanner(f);
                    while (myReader.hasNextLine()) {
                        String line = myReader.nextLine();
                        String end = String.valueOf(line.charAt(line.length() - 1));
                        if (";".equals(end) || ":".equals(end) || ".".equals(end)) {
                            out.add(line);
                        } else {
                            throw new IncorrectFormatException("Incorrect format");
                        }
                    }
                    myReader.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (String l : out) {
            System.out.println(l);
        }

        return out;
    }

    public static void run() {
        ArrayList<String> grammar = readFile();
        GUI gui = new GUI(grammar);
    }

    public static void main(String[] args) {
        run();
    }

}
