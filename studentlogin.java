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
import javax.swing.JTextField;

public class studentlogin implements ActionListener {
  private JFrame frame;
  private JPanel panel;
  private JLabel userLabel;
  private JTextField userText;
  private JLabel idLabel;
  private JTextField idText;
  private JButton loginButton;
  private JButton backButton;

  public studentlogin() {
    frame = new JFrame("Student Login Page");
    panel = new JPanel();
    userLabel = new JLabel("Student's Name:");
    userText = new JTextField(20);
    idLabel = new JLabel("Email ID:");
    idText = new JTextField(20);
    loginButton = new JButton("Login");
    backButton  = new JButton("Back");

    loginButton.addActionListener(this);
    backButton.addActionListener(this);

    panel.add(userLabel);
    panel.add(userText);
    panel.add(idLabel);
    panel.add(idText);
    panel.add(loginButton);
    panel.add(backButton);


    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 250);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String url = "jdbc:mysql://localhost:3306/library";
    String user = "root";
    String password = "R@NiLOVesOscAr2002";

    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      String sql = "SELECT * FROM studentlist WHERE Name=? AND Email_id=?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, userText.getText());
      stmt.setString(2, idText.getText());
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        JOptionPane.showMessageDialog(null, "Login successful!");
        frame.dispose();
        new ViewBooksGUI();
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
    new studentlogin();
  }

public void setVisible(boolean b) {
}
}