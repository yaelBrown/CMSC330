package proj.Project1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    public GUI(ArrayList<String> gram) {
        this.frame = new JFrame();
        this.panel = new JPanel();
        guiParser(gram);
        this.frame.setVisible(true);
    }

    JFrame frame;
    JPanel panel;

    public void guiParser(ArrayList<String> d) {
        guiParserHelper(d, 0, this.panel);
    }

    private void guiParserHelper(ArrayList<String> a, int idx, JPanel pnl) {
        if (idx >= a.size()) {
            return;
        }
        String[] line  = a.get(idx).split(" ");
        System.out.println("line[0] = " + line[0]);
        switch (line[0]) {
            case "Window":
                this.frame = new JFrame(line[1].substring(1,line[1].length()-1));

                int width = Integer.parseInt(line[2].substring(1, endVal(line[2])));
                int height = Integer.parseInt(line[3].substring(0, endVal(line[3])));

                this.frame.setSize(width, height);
                this.frame.setLocationRelativeTo(null);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                if (line[4].equals("Layout")) {
                    if (line[5].equals("Flow:")) {
                        FlowLayout fl = new FlowLayout();
                        fl.setAlignment(FlowLayout.TRAILING);
                        pnl.setLayout(fl);
                        this.frame.add(pnl);
                    } else {
                        pnl = new JPanel();
                    }
                }
                break;
            case "Panel":
                // this.frame.add(pnl);

                int row = Integer.parseInt(line[2].substring(5, endVal(line[2])));
                int col = Integer.parseInt(line[3].substring(0, endVal(line[3])));
                int hgap = Integer.parseInt(line[4].substring(0, endVal(line[4])));
                int vgap = Integer.parseInt(line[5].substring(0, endVal(line[5]) - 1));

                JPanel tempPnl = new JPanel();
                tempPnl.setLayout(new GridLayout(row, col, hgap, vgap));

                break;
            case "Textfield":
                if (line[1].equals("\"\";")) {
                    JTextField tf = new JTextField();
                    pnl.add(tf);
                } else {
                    JTextField tf = new JTextField("", Integer.parseInt(line[1].substring(0, line[1].length() - 1)));
                    pnl.add(tf);
                }
                break;
            case "Label":
                if (line[1].equals("\"\";")) {
                    Label l = new Label();
                    pnl.add(l);
                } else {
                    Label l = new Label(line[1]);
                    pnl.add(l);
                }
                break;
            case "Button":
                Button b = new Button(line[1].substring(1, endVal(line[1]) - 1));
                pnl.add(b);
                b = null;
                break;
            case "End;":
                break;
            default:
                break;
        }
        guiParserHelper(a, idx + 1, pnl);
    }

    private int endVal(String s) {
        return s.length() - 1;
    }
}
