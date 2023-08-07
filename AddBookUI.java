import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel BooknameLabel;
    private JTextField BooknameField;
    private JLabel AuthornameLabel;
    private JTextField AuthornameField;
     private JLabel SubjectnameLabel;
    private JTextField SubjectnameField;
     private JLabel QuantityLabel;
    private JTextField QuantityField;
     
    private JButton addButton;
    private JButton homeButton;

    public AddBookUI() {
        super("Add Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout());
        idLabel = new JLabel("ID:");
        idField = new JTextField(20);
        BooknameLabel = new JLabel("Bookname:");
        BooknameField = new JTextField(20);
        AuthornameLabel = new JLabel("Authorname:");
        AuthornameField=  new JTextField(20);
        SubjectnameLabel = new JLabel("Subjectname:");
        SubjectnameField = new JTextField(20);
        QuantityLabel = new JLabel("Quantity:");
        QuantityField = new JTextField(20);

        

         
        addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(idField.getText());
                String Bookname = BooknameField.getText();
                String Authorname = AuthornameField.getText();
                String Subjectname = SubjectnameField.getText();
                int Quantity = Integer.parseInt(QuantityField.getText());
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "R@NiLOVesOscAr2002");
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO books (id,Bookname,Authorname,Subjectname,Quantity) VALUES (?, ?, ?, ?, ?)");
                    ps.setInt(1, ID);
                    ps.setString(2, Bookname);
                    ps.setString(3, Authorname);
                    ps.setString(4, Subjectname);
                    ps.setInt(5, Quantity);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
               
            }
        });


        homeButton  = new JButton("Home");
         homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               if(e.getSource()==homeButton){
        new LoginFrame();
        dispose();
      }

     } });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(BooknameLabel);
        panel.add(BooknameField);
        panel.add(AuthornameLabel);
        panel.add(AuthornameField);
        panel.add(SubjectnameLabel);
        panel.add(SubjectnameField);
        panel.add(QuantityLabel);
        panel.add(QuantityField);
        panel.add(addButton);
        panel.add(homeButton);

        add(panel);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddBookUI();
    }
}

