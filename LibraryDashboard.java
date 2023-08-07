import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  

public class LibraryDashboard extends JFrame implements ActionListener {


    private JLabel lblBooks, lblStudents, lblBorrowed, lblOverdue;
    private int numBooks, numStudents, numBorrowed, numOverdue;
    private JPanel panel;
    private JButton addButton;

    public LibraryDashboard() {
        // Initialize the dashboard
        setTitle("Library Management System Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
       

        // Connect to the database and retrieve data
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "R@NiLOVesOscAr2002");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM booklist");
            if (rs.next()) {
                numBooks = rs.getInt(1);
            }
            rs = stmt.executeQuery("SELECT COUNT(*) FROM studentlist");
            if (rs.next()) {
                numStudents = rs.getInt(1);
            }
            rs = stmt.executeQuery("SELECT COUNT(*) FROM booklist WHERE status = 'Borrowed'");
            if (rs.next()) {
                numBorrowed = rs.getInt(1);
            }
            rs = stmt.executeQuery("SELECT COUNT(*) FROM booklist WHERE due_date < NOW() AND status = 'Borrowed'");
            if (rs.next()) {
                numOverdue = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

         
        // Create labels to display data
        lblBooks = new JLabel("Number of Books: " + numBooks);
        lblStudents = new JLabel("Number of Students: " + numStudents);
        lblBorrowed = new JLabel("Number of Borrowed Books: " + numBorrowed);
        lblOverdue = new JLabel("Number of Overdue Books: " + numOverdue);
        addButton  = new JButton("Add Books");
        panel = new JPanel();
        // Add labels to the dashboard
        add(lblBooks);
        add(lblStudents);
        add(lblBorrowed);
        add(lblOverdue);
        
        addButton.addActionListener(this);
        panel.add(addButton);
        // Display the dashboard
        setVisible(true);
    }

 
         private JButton getSource() {
        return null;
    }


        public static void main(String[] args) {
                  LibraryDashboard Lib = new LibraryDashboard();
    }


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
       if(e.getSource()==addButton){
        new AddBookUI();
        dispose();
 
        private void dispose() {
  }

      }
  
       
        }
} 
    