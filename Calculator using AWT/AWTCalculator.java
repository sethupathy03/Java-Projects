import java.awt.*;
import java.awt.event.*;

class AWTCalculator implements ActionListener {
    Frame f;
    TextField tf;
    Button[] numButtons = new Button[10];
    Button add, sub, mul, div, eq, clr;
    double num1, num2, result;
    char operator;

    public AWTCalculator() {
        f = new Frame("AWT Calculator");
        tf = new TextField();
        tf.setBounds(50, 50, 250, 50);
        tf.setEditable(false);

        // Alignment positions for Number buttons
        int x = 50, y = 120;
        
        // Colors for buttons
        Color digitColor = new Color(230,230,230);
        Color operatorColor = new Color(250,160,0);
        Color equalColor = new Color(50,205,50);
        Color clearColor = new Color(220,20,60);

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new Button(String.valueOf(i));
            numButtons[i].setBounds(x, y, 50, 50);
            numButtons[i].setBackground(digitColor);
            numButtons[i].addActionListener(this);
            f.add(numButtons[i]);
            x += 60;
            if ((i+1) % 3 == 0) {
                x = 50;
                y += 60;
            }
        }

        // Operator buttons
        add = new Button("+"); add.setBounds(230, 120, 50, 50);
        sub = new Button("-"); sub.setBounds(230, 180, 50, 50);
        mul = new Button("*"); mul.setBounds(230, 240, 50, 50);
        div = new Button("/"); div.setBounds(230, 300, 50, 50);
        eq = new Button("="); eq.setBounds(110, 300, 50, 50);
        clr = new Button("C"); clr.setBounds(170, 300, 50, 50);

        Button[] ops = {add, sub, mul, div};
        for (Button b : ops) {
            b.setBackground(operatorColor);
            b.addActionListener(this);
            f.add(b);
        }
        clr.setBackground(clearColor);
        eq.setBackground(equalColor);
        eq.addActionListener(this);
        f.add(eq);
        clr.addActionListener(this);
        f.add(clr);
        

        f.add(tf);
        f.setSize(350, 400);
        f.setLayout(null);
        f.setVisible(true);

        // Close window
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                tf.setText(tf.getText() + i);
                return;
            }
        }

        if (e.getSource() == add) {
            num1 = Double.parseDouble(tf.getText());
            operator = '+';
            tf.setText("");
        } else if (e.getSource() == sub) {
            num1 = Double.parseDouble(tf.getText());
            operator = '-';
            tf.setText("");
        } else if (e.getSource() == mul) {
            num1 = Double.parseDouble(tf.getText());
            operator = '*';
            tf.setText("");
        } else if (e.getSource() == div) {
            num1 = Double.parseDouble(tf.getText());
            operator = '/';
            tf.setText("");
        } else if (e.getSource() == eq) {
            num2 = Double.parseDouble(tf.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            tf.setText(String.valueOf(result));
        } else if (e.getSource() == clr) {
            tf.setText("");
        }
    }

    public static void main(String[] args) {
        new AWTCalculator();
    }
}
