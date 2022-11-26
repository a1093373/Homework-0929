import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class MYframe extends JFrame implements ActionListener {
    private static String text = "";
    private JTextField textField;
    private int ans;

    public MYframe() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 430, 600);
        setVisible(true);
        setTitle("mycalculator");

        JPanel contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 10, 400, 50);
        contentPanel.add(textField);
        textField.setText("歡迎使用計算機");
        JButton bnt1 = new JButton("1");
        bnt1.setBounds(20, 70, 100, 80);
        bnt1.addActionListener(this);
        contentPanel.add(bnt1);
        JButton bnt2 = new JButton("2");
        bnt2.setBounds(150, 70, 100, 80);
        bnt2.addActionListener(this);
        contentPanel.add(bnt2);
        JButton bnt3 = new JButton("3");
        bnt3.setBounds(280, 70, 100, 80);
        bnt3.addActionListener(this);
        contentPanel.add(bnt3);
        JButton bnt4 = new JButton("4");
        bnt4.setBounds(20, 170, 100, 80);
        bnt4.addActionListener(this);
        contentPanel.add(bnt4);
        JButton bnt5 = new JButton("5");
        bnt5.setBounds(150, 170, 100, 80);
        bnt5.addActionListener(this);
        contentPanel.add(bnt5);
        JButton bnt6 = new JButton("6");
        bnt6.setBounds(280, 170, 100, 80);
        bnt6.addActionListener(this);
        contentPanel.add(bnt6);
        JButton bnt7 = new JButton("7");
        bnt7.setBounds(20, 270, 100, 80);
        bnt7.addActionListener(this);
        contentPanel.add(bnt7);
        JButton bnt8 = new JButton("8");
        bnt8.setBounds(150, 270, 100, 80);
        bnt8.addActionListener(this);
        contentPanel.add(bnt8);
        JButton bnt9 = new JButton("9");
        bnt9.setBounds(280, 270, 100, 80);
        bnt9.addActionListener(this);
        contentPanel.add(bnt9);
        JButton bntplus = new JButton("+");
        bntplus.setBounds(20, 370, 100, 80);
        bntplus.addActionListener(this);
        contentPanel.add(bntplus);
        JButton bnt0 = new JButton("0");
        bnt0.setBounds(150, 370, 100, 80);
        bnt0.addActionListener(this);
        contentPanel.add(bnt0);
        JButton bntsub = new JButton("-");
        bntsub.setBounds(280, 370, 100, 80);
        bntsub.addActionListener(this);
        contentPanel.add(bntsub);
        JButton bntx = new JButton("x");
        bntx.setBounds(20, 470, 100, 80);
        bntx.addActionListener(this);
        contentPanel.add(bntx);
        JButton bntequl = new JButton("=");
        bntequl.setBounds(150, 470, 100, 80);
        bntequl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> integer = new ArrayList<>();
                ArrayList<Character> str = new ArrayList<>();
                int index = 0;
                for (int i = 0; i < text.length(); i++) {
                    switch (text.charAt(i)) {
                        case 'x':
                            integer.add(Integer.parseInt(text.substring(index, i)));
                            index = i + 1;
                            str.add('x');
                            break;
                        case '/':
                            integer.add(Integer.parseInt(text.substring(index, i)));
                            index = i + 1;
                            str.add('/');
                            break;
                        case '+':
                            integer.add(Integer.parseInt(text.substring(index, i)));
                            index = i + 1;
                            str.add('+');
                            break;
                        case '-':
                            integer.add(Integer.parseInt(text.substring(index, i)));
                            index = i + 1;
                            str.add('-');
                            break;
                    }
                    if (i == text.length() - 1) {
                        integer.add(Integer.parseInt(text.substring(index, i + 1)));
                        System.out.println(integer);
                        System.out.println(str);
                        while (str.contains('x') || str.contains('/')) {
                            if (str.contains('x')) {
                                integer.add(str.indexOf('x') + 2,
                                        integer.get(str.indexOf('x')) * integer.get(str.indexOf('x') + 1));
                                integer.remove(str.indexOf('x') + 1);
                                integer.remove(str.indexOf('x'));
                                str.remove(str.indexOf('x'));
                            }
                            if (str.contains('/')) {
                                integer.add(str.indexOf('/') + 2,
                                        integer.get(str.indexOf('/')) / integer.get(str.indexOf('/') + 1));
                                integer.remove(str.indexOf('/') + 1);
                                integer.remove(str.indexOf('/'));
                                str.remove(str.indexOf('/'));
                            }
                        }
                        System.out.println("After execute:" + integer);
                        System.out.println("After execute:" + str);
                        ans = integer.get(0);
                        for (int op = 0; op < str.size(); op++) {
                            switch (str.get(op)) {
                                case '+':
                                    ans += integer.get(op + 1);
                                    break;
                                case '-':
                                    ans -= integer.get(op + 1);
                                    break;
                            }
                        }
                        text = "";
                        textField.setText(Integer.toString(ans));
                    }
                }
            }
        });
        contentPanel.add(bntequl);
        JButton bntdiv = new JButton("/");
        bntdiv.setBounds(280, 470, 100, 80);
        bntdiv.addActionListener(this);
        contentPanel.add(bntdiv);
    }

    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        text = text.concat(bt.getText());
        textField.setText(text);
    }
}

public class swing_practice {
    public static void main(String[] args) {
        MYframe f1 = new MYframe();
    }
}