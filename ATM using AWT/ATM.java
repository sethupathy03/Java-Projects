import java.awt.*;
import java.awt.event.*;

class ATM extends Frame implements ActionListener {

    Label title, l1, l2, msg;
    TextField pinField, amountField;
    Button loginBtn, depositBtn, withdrawBtn, balanceBtn, exitBtn;

    int balance = 5000;
    int pin = 1234;

    ATM() {
        // Frame Settings
        setTitle("ATM Machine");
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        

        // Colors for buttons
        Color loginColor = new Color(0,250,0);
        Color withdrawColor = new Color(200,250,180);
        Color balanceColor = new Color(0,250,240);
        Color exitColor = new Color(0,150,240);
        Color depositColor = new Color(100,100,100);

        // Title
        title = new Label("ATM MACHINE", Label.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,14));
        title.setBounds(100, 40, 200, 30);
        add(title);

        // PIN
        l1 = new Label("Enter PIN:");
        l1.setBounds(80, 100, 100, 25);
        add(l1);

        pinField = new TextField();
        pinField.setEchoChar('*');
        pinField.setBounds(180, 100, 120, 25);
        add(pinField);

        loginBtn = new Button("LOGIN");
        loginBtn.setBounds(140, 140, 100, 30);
        loginBtn.setBackground(loginColor);
        loginBtn.setFont(new Font("Arial",Font.BOLD,14));
        loginBtn.setForeground(Color.WHITE);
        add(loginBtn);


        // Amount
        l2 = new Label("Amount:");
        l2.setBounds(80, 190, 100, 25);
        add(l2);

        amountField = new TextField();
        amountField.setBounds(180, 190, 120, 25);
        add(amountField);

        // Buttons
        depositBtn = new Button("DEPOSIT");
        withdrawBtn = new Button("WITHDRAW");
        balanceBtn = new Button("BALANCE");
        exitBtn = new Button("EXIT");


        depositBtn.setBounds(50, 240, 120, 30);
        depositBtn.setBackground(depositColor);
        depositBtn.setFont(new Font("Arial",Font.BOLD,12));
        depositBtn.setForeground(Color.WHITE);

        withdrawBtn.setBounds(200, 240, 120, 30);
        withdrawBtn.setBackground(withdrawColor);
        withdrawBtn.setFont(new Font("Arial",Font.BOLD,12));
        withdrawBtn.setForeground(Color.WHITE);

        balanceBtn.setBounds(50, 290, 120, 30);
        balanceBtn.setBackground(balanceColor);
        balanceBtn.setFont(new Font("Arial",Font.BOLD,12));
        balanceBtn.setForeground(Color.WHITE);
        
        exitBtn.setBounds(200, 290, 120, 30);
        exitBtn.setBackground(exitColor);
        exitBtn.setFont(new Font("Arial",Font.BOLD,12));
        exitBtn.setForeground(Color.WHITE);

        add(depositBtn);
        add(withdrawBtn);
        add(balanceBtn);
        add(exitBtn);

        // Message
        msg = new Label("");
        msg.setFont(new Font("Arial",Font.BOLD,12));
        msg.setBounds(60, 340, 300, 25);
        add(msg);

        // Disable ATM buttons initially
        setATMButtons(false);

        // Listeners
        loginBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    void setATMButtons(boolean status) {
        depositBtn.setEnabled(status);
        withdrawBtn.setEnabled(status);
        balanceBtn.setEnabled(status);
        exitBtn.setEnabled(status);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            int enteredPin = Integer.parseInt(pinField.getText());

            if (enteredPin == pin) {
                msg.setText("Login Successful!");
                setATMButtons(true);
            } else {
                msg.setText("Invalid PIN!");
            }
        }

        if (e.getSource() == depositBtn) {
            int amt = Integer.parseInt(amountField.getText());
            balance += amt;
            msg.setText("Deposited ₹" + amt);
        }

        if (e.getSource() == withdrawBtn) {
            int amt = Integer.parseInt(amountField.getText());

            if (amt <= balance) {
                balance -= amt;
                msg.setText("Withdrawn ₹" + amt);
            } else {
                msg.setText("Insufficient Balance!");
            }
        }

        if (e.getSource() == balanceBtn) {
            msg.setText("Current Balance: ₹" + balance);
        }

        if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new ATM();
    }
}
