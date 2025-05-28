import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;
public class Loading extends JFrame implements Runnable {
	Thread t;
	JProgressBar bar;
	String username;
	
	public void run() {
		try {
			for (int i=1; i<=101;i++) {
				int max=bar.getMaximum();
				int value=bar.getValue();
				
				if(value<max) {
					bar.setValue(bar.getValue()+1);
					
				}else {
					setVisible(false);
					new Dashboard(username);
				}
				Thread.sleep(50);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Loading(String username){
		this.username=username;
		t=new Thread(this);
		setBounds(500,200,650,400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text =new JLabel("Travel and Tourism application");
		text.setBounds(50,20,600,40);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Raleway",Font.BOLD,35));
		add(text);
		
		bar =new JProgressBar();
		bar.setBounds(150,100,300,35);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel loadling =new JLabel("Loading please wait..");
		loadling.setBounds(230,140,150,30);
		loadling.setForeground(Color.pink);
		loadling.setFont(new Font("Raleway",Font.BOLD,16));
		add(loadling);
		
		JLabel lblusername =new JLabel("Welcome"+ username);
		lblusername.setBounds(20,310,400,40);
		lblusername.setForeground(Color.pink);
		lblusername.setFont(new Font("Raleway",Font.BOLD,16));
		add(lblusername);
		
		t.start();
		setVisible(true);
		
		
		
		
	}


	public static void main(String[] args) {
	    try {
	        Conn c = new Conn();
	        ResultSet rs = c.s.executeQuery("SELECT username FROM account LIMIT 1"); // or use FETCH FIRST 1 ROWS ONLY for some DBs
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
