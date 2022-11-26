import java.awt.Color;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.FlowLayout;
import java.awt.event.*;

class myJFrame6 extends JFrame implements ListSelectionListener {
    JLabel jla1;
    JList<String> jl1;
    JTextArea jta1;
    String locations[] = { "台北", "桃園", "台中", "彰化", "嘉義", "高雄", "屏東", "台東", "花蓮", "宜蘭" };;
    String mountain[] = { "象山", "龜山", "大肚肚山", "八卦山", "阿里山", "半屏山", "好山好水", "鯉魚山", "壽豐山", "抹茶山" };

    public myJFrame6() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("各地名山");
        setBounds(0, 0, 300, 300);
        setVisible(true);
        setLayout(null);

        jla1 = new JLabel("找各地名山：");
        add(jla1);
        jla1.setBounds(40, 40, 100, 20);

        jl1 = new JList<String>(locations);
        jl1.addListSelectionListener(this);
        JScrollPane jsp1 = new JScrollPane(jl1);
        add(jsp1);
        jsp1.setBounds(120, 20, 100, 120);

        jta1 = new JTextArea("可選取地名...");
        JScrollPane jsp2 = new JScrollPane(jta1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp2.setBounds(40, 150, 200, 100);
        add(jsp2);
    }

    public void valueChanged(ListSelectionEvent e) {
        String text = "";
        for (int i = 0; i < locations.length; i++) {
            if (jl1.isSelectedIndex(i)) {
                text = text + locations[i] + "名山" + " : " + mountain[i] + "\n";
            }
        }
        jta1.setText(text);

    }
}

public class swing3_practice {
    public static void main(String[] args) {
        myJFrame6 f6 = new myJFrame6();
    }
}