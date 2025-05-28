import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminDashboard extends JFrame implements ActionListener {
    String adminUsername;
    JButton viewCustomers, manageHotels, managePackages, deleteCustomer, logout;
    
    AdminDashboard(String adminUsername) {
        this.adminUsername = adminUsername;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setLayout(null);
        
        // Header Panel
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(0, 0, 102));
        header.setBounds(0, 0, 1600, 65);
        add(header);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        header.add(icon);
        
        JLabel heading = new JLabel("Admin Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        header.add(heading);
        
        // Sidebar Panel
        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(0, 0, 102));
        sidebar.setBounds(0, 65, 300, 900);
        add(sidebar);
        
        // Buttons for Admin Actions
        viewCustomers = new JButton("View All Customers");
        viewCustomers.setBounds(0, 0, 300, 50);
        viewCustomers.setBackground(new Color(0, 0, 102));
        viewCustomers.setForeground(Color.WHITE);
        viewCustomers.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewCustomers.setMargin(new Insets(0, 0, 0, 60));
        viewCustomers.addActionListener(this);
        sidebar.add(viewCustomers);
        
        manageHotels = new JButton("Manage Hotels");
        manageHotels.setBounds(0, 50, 300, 50);
        manageHotels.setBackground(new Color(0, 0, 102));
        manageHotels.setForeground(Color.WHITE);
        manageHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        manageHotels.setMargin(new Insets(0, 0, 0, 90));
        manageHotels.addActionListener(this);
        sidebar.add(manageHotels);
        
        managePackages = new JButton("Manage Packages");
        managePackages.setBounds(0, 100, 300, 50);
        managePackages.setBackground(new Color(0, 0, 102));
        managePackages.setForeground(Color.WHITE);
        managePackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        managePackages.setMargin(new Insets(0, 0, 0, 80));
        managePackages.addActionListener(this);
        sidebar.add(managePackages);
        
        deleteCustomer = new JButton("Delete Customer");
        deleteCustomer.setBounds(0, 150, 300, 50);
        deleteCustomer.setBackground(new Color(0, 0, 102));
        deleteCustomer.setForeground(Color.WHITE);
        deleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deleteCustomer.setMargin(new Insets(0, 0, 0, 80));
        deleteCustomer.addActionListener(this);
        sidebar.add(deleteCustomer);
        
        logout = new JButton("Logout");
        logout.setBounds(0, 200, 300, 50);
        logout.setBackground(new Color(0, 0, 102));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        logout.setMargin(new Insets(0, 0, 0, 140));
        logout.addActionListener(this);
        sidebar.add(logout);
        
        // Background Image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);
        
        JLabel text = new JLabel("Admin Control Panel - Travel Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 50));
        image.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewCustomers) {
            new ViewAllCustomers();
        } else if (ae.getSource() == manageHotels) {
            new ManageHotels();
        } else if (ae.getSource() == managePackages) {
            new ManagePackages();
        } else if (ae.getSource() == deleteCustomer) {
            new AdminDeleteCustomer();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new AdminLogin();
        }
    }
    
    public static void main(String[] args) {
        new AdminDashboard("admin");
    }
}

// Helper class to view all customers
class ViewAllCustomers extends JFrame {
    ViewAllCustomers() {
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 20, 820, 500);
        textArea.setEditable(false);
        add(textArea);
        
        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(380, 530, 100, 25);
        back.addActionListener(e -> setVisible(false));
        add(back);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer");
            StringBuilder data = new StringBuilder("Customers List:\n\n");
            while (rs.next()) {
                data.append("Username: ").append(rs.getString("username")).append("\n")
                    .append("ID: ").append(rs.getString("id")).append("\n")
                    .append("Number: ").append(rs.getString("number")).append("\n")
                    .append("Name: ").append(rs.getString("name")).append("\n")
                    .append("Gender: ").append(rs.getString("gender")).append("\n")
                    .append("Country: ").append(rs.getString("country")).append("\n")
                    .append("Address: ").append(rs.getString("address")).append("\n")
                    .append("Phone: ").append(rs.getString("phone")).append("\n")
                    .append("Email: ").append(rs.getString("email")).append("\n\n");
            }
            textArea.setText(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
}

// Helper class to manage hotels
class ManageHotels extends JFrame implements ActionListener {
    JTextField tfHotelName, tfCostPerPerson, tfACRoom, tfFoodIncluded;
    JButton addHotel, back;
    
    ManageHotels() {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblName = new JLabel("Hotel Name");
        lblName.setBounds(30, 50, 150, 25);
        add(lblName);
        
        tfHotelName = new JTextField();
        tfHotelName.setBounds(220, 50, 150, 25);
        add(tfHotelName);
        
        JLabel lblCost = new JLabel("Cost Per Person");
        lblCost.setBounds(30, 90, 150, 25);
        add(lblCost);
        
        tfCostPerPerson = new JTextField();
        tfCostPerPerson.setBounds(220, 90, 150, 25);
        add(tfCostPerPerson);
        
        JLabel lblAC = new JLabel("AC Room Cost");
        lblAC.setBounds(30, 130, 150, 25);
        add(lblAC);
        
        tfACRoom = new JTextField();
        tfACRoom.setBounds(220, 130, 150, 25);
        add(tfACRoom);
        
        JLabel lblFood = new JLabel("Food Included Cost");
        lblFood.setBounds(30, 170, 150, 25);
        add(lblFood);
        
        tfFoodIncluded = new JTextField();
        tfFoodIncluded.setBounds(220, 170, 150, 25);
        add(tfFoodIncluded);
        
        addHotel = new JButton("Add Hotel");
        addHotel.setBackground(Color.BLACK);
        addHotel.setForeground(Color.WHITE);
        addHotel.setBounds(70, 230, 100, 25);
        addHotel.addActionListener(this);
        add(addHotel);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 230, 100, 25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addHotel) {
            String name = tfHotelName.getText();
            String cost = tfCostPerPerson.getText();
            String ac = tfACRoom.getText();
            String food = tfFoodIncluded.getText();
            
            try {
                Conn c = new Conn();
                String query = "INSERT INTO hotel (name, costperperson, acroom, foodincluded) VALUES ('" + name + "', '" + cost + "', '" + ac + "', '" + food + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}

// Helper class to manage packages
class ManagePackages extends JFrame implements ActionListener {
    JTextField tfPackageName, tfCost;
    JButton addPackage, back;
    
    ManagePackages() {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblName = new JLabel("Package Name");
        lblName.setBounds(30, 50, 150, 25);
        add(lblName);
        
        tfPackageName = new JTextField();
        tfPackageName.setBounds(220, 50, 150, 25);
        add(tfPackageName);
        
        JLabel lblCost = new JLabel("Package Cost");
        lblCost.setBounds(30, 90, 150, 25);
        add(lblCost);
        
        tfCost = new JTextField();
        tfCost.setBounds(220, 90, 150, 25);
        add(tfCost);
        
        addPackage = new JButton("Add Package");
        addPackage.setBackground(Color.BLACK);
        addPackage.setForeground(Color.WHITE);
        addPackage.setBounds(70, 150, 100, 25);
        addPackage.addActionListener(this);
        add(addPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 150, 100, 25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPackage) {
            String name = tfPackageName.getText();
            String cost = tfCost.getText();
            
            try {
                Conn c = new Conn();
                String query = "INSERT INTO package (name, cost) VALUES ('" + name + "', '" + cost + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}

// Helper class to delete a customer
class AdminDeleteCustomer extends JFrame implements ActionListener {
    JTextField tfUsername;
    JButton delete, back;
    
    AdminDeleteCustomer() {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(220, 50, 150, 25);
        add(tfUsername);
        
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(70, 100, 100, 25);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 100, 100, 25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            String username = tfUsername.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("DELETE FROM account WHERE username='" + username + "'");
                c.s.executeUpdate("DELETE FROM customer WHERE username='" + username + "'");
                c.s.executeUpdate("DELETE FROM bookpackage WHERE username='" + username + "'");
                c.s.executeUpdate("DELETE FROM bookhotel WHERE username='" + username + "'");
                JOptionPane.showMessageDialog(null, "Customer Data Deleted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}