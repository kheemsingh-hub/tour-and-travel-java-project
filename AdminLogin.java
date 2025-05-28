import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener {
    JButton login, back;
    JTextField tfusername, tfpassword;

    AdminLogin() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Left Panel with Image
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 400, 400);
        panel.setLayout(null);
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        panel.add(image);

        // Right Panel for Login Form
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        // Username Field
        JLabel lblusername = new JLabel("Admin Username");
        lblusername.setBounds(60, 20, 150, 40);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        // Password Field
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        // Login Button
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(Color.CYAN);
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(134, 194, 234)));
        login.addActionListener(this);
        p2.add(login);

        // Back Button
        back = new JButton("Back to User Login");
        back.setBounds(230, 200, 130, 30);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(134, 194, 234)));
        back.addActionListener(this);
        p2.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
                Conn c = new Conn();
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    setVisible(false);
                    new AdminDashboard(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect admin username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }
}