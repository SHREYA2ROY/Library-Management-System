import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;

public class ViewBooksGUI extends JFrame implements ActionListener {
  private JButton viewButton;
  private JTextArea bookList;
 // private JButton homeButton;

  public ViewBooksGUI() {
    // Create button
    viewButton = new JButton("View Books");
   // homeButton  = new JButton("Home");

    // Add action listener
    viewButton.addActionListener(this);
   

    // Create text area
    bookList = new JTextArea(50, 100);
    bookList.setEditable(false);

    // Add components to frame
    add(viewButton, BorderLayout.NORTH);
   add(new JScrollPane(bookList), BorderLayout.CENTER);
   // add(homeButton);
    
    // Set frame properties
    setTitle("View Books");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewButton) {
      try {
        
        // Connect to database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "R@NiLOVesOscAr2002");

        // Create statement
        Statement stmt = conn.createStatement();

        // Execute query
        ResultSet rs = stmt.executeQuery("SELECT Bookname FROM books");

        // Clear text area
        bookList.setText("");

        // Loop through results and append data to text area
        while (rs.next()) {
          String bookName = rs.getString("Bookname");
          bookList.append(bookName + "\n");
        }

        // Close resources
        rs.close();
        stmt.close();
        conn.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  

 // homeButton.addActionListener(new ActionListener() {
   //       public void actionPerformed(ActionEvent e){
     //         if(e.getSource()==homeButton){
       // new LoginFrame();
        //dispose();
      //}

     //} });
     
    }


  


  public static void main(String[] args) {
    new ViewBooksGUI();
  }
}