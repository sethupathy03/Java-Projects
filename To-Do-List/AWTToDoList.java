import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class AWTToDoList implements ActionListener {
    Frame f;
    TextField taskInput;
    Button addBtn, removeBtn;
    List taskList; // AWT List
    ArrayList<String> tasks;

    public AWTToDoList() {
        f = new Frame("AWT To-Do List");
        f.setSize(400, 400);
        f.setLayout(null);

        tasks = new ArrayList<>();

        Label title = new Label("My To-Do List");
        title.setBounds(150, 40, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        f.add(title);

        taskInput = new TextField();
        taskInput.setBounds(50, 80, 200, 30);
        f.add(taskInput);

        addBtn = new Button("Add Task");
        addBtn.setBounds(270, 80, 80, 30);
        addBtn.setBackground(new Color(0,250,0));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Arial",Font.BOLD,13));
        addBtn.addActionListener(this);
        f.add(addBtn);

        taskList = new List();
        taskList.setBounds(50, 130, 300, 150);
        f.add(taskList);

        removeBtn = new Button("Remove Selected");
        removeBtn.setBounds(120, 300, 150, 30);
        removeBtn.setBackground(new Color(230,0,0));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFont(new Font("Arial",Font.BOLD,13));
        removeBtn.addActionListener(this);
        f.add(removeBtn);

        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskList.add(task);
                taskInput.setText("");
            }
        } else if (e.getSource() == removeBtn) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0) {
                taskList.remove(selectedIndex);
                tasks.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new AWTToDoList();
    }
}
