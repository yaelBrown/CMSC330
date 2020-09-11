package proj.Project1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    public GUI() {}
    public GUI(ArrayList<String> gram) {
        guiParser(gram);
        this.frame.setVisible(true);
    }

    JFrame frame;
    JPanel panel;

    public void guiParser(ArrayList<String> d) {
        for (String s : d) {
            guiParserHelper(s);
        }
    }

    private void guiParserHelper(String s) {
        String[] line  = s.split(" ");
        System.out.println("line[0] = " + line[0]);
        switch (line[0]) {
            case "Window":
                this.frame = new JFrame(line[1].substring(1,line[1].length()-1));

                int width = Integer.parseInt(line[2].substring(1, endVal(line[2])));
                int height = Integer.parseInt(line[3].substring(0, endVal(line[3])));

                this.frame.setSize(width, height);
                this.frame.setLocationRelativeTo(null);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
            case "Panel":
                this.panel = new JPanel();

                int row = Integer.parseInt(line[2].substring(5, endVal(line[2])));
                int col = Integer.parseInt(line[3].substring(0, endVal(line[3])));
                int hgap = Integer.parseInt(line[4].substring(0, endVal(line[4])));
                int vgap = Integer.parseInt(line[5].substring(0, endVal(line[5]) - 1));

                this.panel.setLayout(new GridLayout(row, col, hgap, vgap));
                this.frame.add(this.panel);
                break;
            case "Textfield":
                JTextField tf = new JTextField(line[1]);
                this.frame.add(tf);
                break;
            case "Label":
                Label l = new Label(line[1]);
                this.frame.add(l);
                break;
            case "Button":
     -           Button b = new Button(line[1].substring(1, endVal(line[1]) - 1));
                this.panel.add(b);
                b = null;
                break;
            default:
                break;
        }
        return;
    }

    private int endVal(String s) {
        return s.length() - 1;
    }

}
