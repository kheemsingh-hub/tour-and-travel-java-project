import java.awt.*;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
	
	JLabel labelusername,labelname;
	JComboBox comboid;
	JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;
	JRadioButton male,female;
	JButton add,back;
	
	AddCustomer(String username){
		setBounds(450,200,850,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblusername = new JLabel("username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(220,50,150,25);
		add(labelusername);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30,90,150,25);
		add(lblid);
		
		comboid=new JComboBox(new String[] {"passport", "Aadhar Card", "Pan Card","Rastion Card"});
		comboid.setBounds(220,90,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,130,150,25);
		add(lblnumber);
		
		tfnumber =new JTextField();
		tfnumber.setBounds(220,130,150,25);
		add(tfnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,170,150,25);
		add(lblname);
		
		labelname = new JLabel();
		labelname.setBounds(220,170,150,25);
		add(labelname);
		
		JLabel lblgender= new JLabel("Gender");
		lblgender.setBounds(30,210,150,25);
		add(lblgender);
		
		male=new JRadioButton("Male");
		male.setBounds(220,210,70,25);
		male.setBackground(Color.WHITE);
		add(male);
		
		
		female=new JRadioButton("Female");
		female.setBounds(300,210,70,25);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JLabel iblcountry = new JLabel("Country");
		iblcountry.setBounds(30,250,150,25);
		add(iblcountry );
		
		tfcountry =new JTextField();
		tfcountry.setBounds(220,250,150,25);
		add(tfcountry);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(30,290,150,25);
		add(lbladdress);
		
		tfaddress =new JTextField();
		tfaddress.setBounds(220,290,150,25);
		add(tfaddress);
		
		JLabel iblemail = new JLabel("Email");
		iblemail.setBounds(30,330,150,25);
		add(iblemail );
		
		tfemail =new JTextField();
		tfemail.setBounds(220,330,150,25);
		add(tfemail);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(30,370,150,25);
		add(lblphone);
		
		tfphone =new JTextField();
		tfphone.setBounds(220,370,150,25);
		add(tfphone);
		
		add=new JButton("Add");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(70,430,100,25);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(220,430,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i4=new ImageIcon(i2);
		JLabel image=new JLabel(i4);
		image.setBounds(400,40,450,420);
		add(image);
		
		try{
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from account where username ='"+username+"'");
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			String username=labelusername.getText();
			String id=(String) comboid.getSelectedItem();
			String number=tfnumber.getText();
			String name=labelname.getText();
			String gender=null;
			if(male.isSelected()) {
				gender="Male";
			}else {
				gender="Female";
			}
			String country=tfcountry.getText();
			String address=tfaddress.getText();
			String email=tfemail.getText();
			String phone =tfphone.getText();
			
			
			try {
				Conn c=new Conn();
				String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+email+"','"+phone+"')";

				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
	    } else {
		   setVisible(false);
	  }
	}
	
		


	public static void main(String[] args) {
	    try {
	        Conn c = new Conn();
	        ResultSet rs = c.s.executeQuery("SELECT username FROM customer LIMIT 1"); // or use FETCH FIRST 1 ROWS ONLY for some DBs
	        if (rs.next()) {
	            String username = rs.getString("username");
	            new UpdateCustomer(username);
	        } else {
	            System.out.println("No customer found in the database.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
	}


