import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    JButton adminLoginButton, studentLoginButton;
    
    public LoginFrame() {
        super("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));


        
        adminLoginButton = new JButton("Admin Login");
        studentLoginButton = new JButton("Student Login");
        
    
        add(adminLoginButton);
        add(studentLoginButton);
        
        adminLoginButton.addActionListener(this);
        studentLoginButton.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adminLoginButton) {
            new LoginPage();
            dispose();
        } else if(e.getSource() == studentLoginButton) {
            new studentlogin();
            dispose();
        }
    }
    
    public static void main(String[] args) {
        new LoginFrame();
    }
}