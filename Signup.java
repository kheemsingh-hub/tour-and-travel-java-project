import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
	
	
	
	JButton create,back;
	JTextField tfname,tfusername,tfpassword,tfanswer;
	Choice security;
	
	Signup(){
		setBounds(350, 200, 900, 360);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setBackground(Color.gray);
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		add(p1);
		
		JLabel iblusername =new JLabel("username");
		iblusername.setFont(new Font("Tahoma", Font.BOLD,14));
		iblusername.setBounds(50,20,125,25);
		p1.add(iblusername);
		
		tfusername=new JTextField();
		tfusername.setBounds(190,20,180,25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);
		
		JLabel lblname =new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.BOLD,14));
		lblname.setBounds(50,60,125,25);
		p1.add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(190,60,180,25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		JLabel lblpassword =new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD,14));
		lblpassword.setBounds(50,100,125,25);
		p1.add(lblpassword);
		
		tfpassword=new JPasswordField();
		tfpassword.setBounds(190,100,180,25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		JLabel lblsecurty =new JLabel("Security quetion");
		lblsecurty.setFont(new Font("Tahoma", Font.BOLD,14));
		lblsecurty.setBounds(50,140,125,25);
		p1.add(lblsecurty);
		
		security=new Choice();
		security.add("Fav Character from the boys");
		security.add("Fav Marvel super hero");
		security.add("your Lucky number..");
		security.add("your childhood super hero");
		security.add("your fav cricket team");
		security.setBounds(190,140 ,180, 25);
		p1.add(security);
		
		JLabel lblanswer =new JLabel("Answer");
		lblanswer.setFont(new Font("Tahoma", Font.BOLD,14));
		lblanswer.setBounds(50,180,125,25);
		p1.add(lblanswer);
		
		tfanswer=new JTextField();
		tfanswer.setBounds(190,180,180,25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
	    create = new JButton("create");
		create.setBackground(Color.white);
		create.setForeground(Color.gray);
		create.setFont(new Font("Tahoma", Font.BOLD, 14));
		create.setBounds(80,250,100,30);
		create.addActionListener(this);
		p1.add(create);
		
		back = new JButton("Back");
		back.setBackground(Color.white);
		back.setForeground(Color.gray);
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.setBounds(250,250,100,30);
		back.addActionListener(this);
		p1.add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(580, 50, 250, 250);
		add(image);
		
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==create) {
			String username=tfusername.getText();
			String name=tfname.getText();
			String password=tfpassword.getText();
			String question=security.getSelectedItem();
			String answer=tfanswer.getText();
			
			String query = "INSERT INTO account(username, name, password, security, answer) " +
		               "VALUES ('" + username + "', '" + name + "', '" + password + "', '" + question + "', '" + answer + "')";

			try {
				Conn c=new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				
				setVisible(false);
				new Login();
				
			}catch(Exception e) {
			     e.printStackTrace();
			}
		}else if(ae.getSource()==back){
			setVisible(false);
			new Login();
		}
	}
  
	public static void main(String[] args){
		new Signup();
	}
}
