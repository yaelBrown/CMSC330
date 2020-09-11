package proj.Project1;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {

    public static ArrayList<String> readFile() {
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
                        out.add(line);
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
