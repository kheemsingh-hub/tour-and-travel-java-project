import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Loginuser extends JFrame implements ActionListener{
	JButton login,signup,password;
	JTextField tfusername,tfpassword;
	Loginuser(){
		setSize(900 , 400);
		setLocation(350 ,200);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.gray);
		panel.setBounds(0,0,400,400);
		panel.setLayout(null);
		add(panel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(100, 120, 200, 200);
		panel.add(image);
		
		JPanel p2 =new JPanel();
		p2.setLayout(null);
		p2.setBounds(400, 30 ,450, 300);
		add(p2);
		
		JLabel iblusername =new JLabel("Username");
		iblusername.setBounds(60, 20 ,100, 25);
		iblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		p2.add(iblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(60, 60, 300, 30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);
		
		JLabel lblpassword =new JLabel("Password");

		lblpassword.setBounds(60, 110 ,100, 25);
		lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		p2.add(lblpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(60, 150, 300, 30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);
		
	    login=new JButton("Login");
		login.setBounds(60, 200, 130, 30);
		login.setBackground(Color.cyan);
		login.setForeground(Color.WHITE);
		login.setBorder(new LineBorder(new Color(134, 194, 234)));
		login.addActionListener(this);
		
		p2.add(login);
		
		signup=new JButton("Signup");
		signup.setBounds(230, 200, 130, 30);
		signup.setBackground(Color.cyan);
		signup.setForeground(Color.WHITE);
		signup.setBorder(new LineBorder(new Color(134, 194, 234)));
		signup.addActionListener(this);
		p2.add(signup);
		
		password=new JButton("Forget Password");
		password.setBounds(130, 250, 130, 30);
		password.setBackground(Color.cyan);
		password.setForeground(Color.WHITE);
		password.setBorder(new LineBorder(new Color(134, 194, 234)));
		password.addActionListener(this);
		p2.add(password);
		
		JLabel text = new JLabel("Trouble in login..");
		text.setBounds(300, 250,150,20);
		text.setForeground(Color.PINK);
		p2.add(text);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			try {
				String username=tfusername.getText();
				String password=tfpassword.getText();
				
				String query ="select * from account where username='"+username+"' AND password='"+password+"'";
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				{
					if(rs.next()) {
						setVisible(false);
						new Loading(username);
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup();
		}else {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
   public static void main(String[] args) {
	   new Loginuser();
   }
}