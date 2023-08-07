import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
  private JFrame frame;
  private JPanel panel;
  private JLabel userLabel;
  private JTextField userText;
  private JLabel passwordLabel;
  private JPasswordField passwordText;
  private JButton loginButton;
  private JButton backButton;

  public LoginPage() {
    frame = new JFrame("Login Page");
    panel = new JPanel();
    userLabel = new JLabel("Admin Name:");
    userText = new JTextField(20);
    passwordLabel = new JLabel("Admin ID:");
    passwordText = new JPasswordField(20);
    loginButton = new JButton("Login");
    backButton  = new JButton("Back");

    loginButton.addActionListener(this);
    backButton.addActionListener(this);

    panel.add(userLabel);
    panel.add(userText);
    panel.add(passwordLabel);
    panel.add(passwordText);
    panel.add(loginButton);
    panel.add(backButton);

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String password = "R@NiLOVesOscAr2002";

    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      String sql = "SELECT * FROM admin WHERE name=? AND id_password=?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, userText.getText());
      stmt.setString(2, new String(passwordText.getPassword()));
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        JOptionPane.showMessageDialog(null, "Login successful!");
        frame.dispose();
        new LibraryDashboard();
      } else {
        JOptionPane.showMessageDialog(null, "Invalid username or password!");
      }

      rs.close();
      stmt.close();
      conn.close();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    if(e.getSource()==backButton){
        new LoginFrame();
        dispose();
      }
  }

  private void dispose() {
  }

  public static void main(String[] args) {
    new LoginPage();
  }

public void setVisible(boolean b) {
}
}