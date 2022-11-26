import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyJFrame4 extends JFrame {
    JPanel contentPanel;
    int imageIndex = 1;

    public MyJFrame4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 700, 700);
        setVisible(true);
        setTitle("swing2.homework");

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPanel);

        ImageIcon img1 = new ImageIcon("C:\\Users\\user\\Desktop\\大二上OOPII\\Swing2_木.jpg");
        img1.setImage(img1.getImage().getScaledInstance(400, 400, DO_NOTHING_ON_CLOSE));
        ImageIcon img2 = new ImageIcon("C:\\Users\\user\\Desktop\\大二上OOPII\\Swing2_林.jpg");
        img2.setImage(img2.getImage().getScaledInstance(400, 400, DO_NOTHING_ON_CLOSE));
        ImageIcon img3 = new ImageIcon("C:\\Users\\user\\Desktop\\大二上OOPII\\Swing2_森.jpg");
        img3.setImage(img3.getImage().getScaledInstance(400, 400, DO_NOTHING_ON_CLOSE));

        ImageIcon imagelist[] = { img1, img2, img3 };
        String imageNameList[] = { "圖片一_木", "圖片二_林", "圖片三_森" };

        JLabel iconName = new JLabel(imageNameList[1], SwingConstants.CENTER);
        iconName.setFont(new Font("標楷體", Font.PLAIN, 22));
        contentPanel.add(iconName, BorderLayout.PAGE_START);

        JLabel jlb1 = new JLabel(imagelist[1]);
        jlb1.setFont(new Font("標楷體", Font.PLAIN, 22));
        jlb1.setBounds(0, 0, 400, 400);
        contentPanel.add(jlb1, BorderLayout.CENTER);

        JPanel btn = new JPanel(new GridLayout(1, 2));
        JButton btnleft = new JButton("上一張");
        btnleft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imageIndex -= 1;
                if (imageIndex < 0 || imageIndex > 2) {
                    iconName.setText("");
                    jlb1.setIcon(null);
                    jlb1.setText("沒有照片啦!");
                } else {
                    jlb1.setText(null);
                    iconName.setText(imageNameList[imageIndex]);
                    jlb1.setIcon(imagelist[imageIndex]);
                }
            }
        });
        btn.add(btnleft);
        JButton btnnext = new JButton("下一張");
        btnnext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imageIndex += 1;
                if (imageIndex > 2 || imageIndex < 0) {
                    iconName.setText("");
                    jlb1.setIcon(null);
                    jlb1.setText("沒有照片啦!");
                } else {
                    jlb1.setText(null);
                    iconName.setText(imageNameList[imageIndex]);
                    jlb1.setIcon(imagelist[imageIndex]);
                }
            }
        });
        btn.add(btnnext);
        contentPanel.add(btn, BorderLayout.PAGE_END);

    }

}

public class swing2_homework {
    public static void main(String[] args) {
        MyJFrame4 f1 = new MyJFrame4();
    }
}