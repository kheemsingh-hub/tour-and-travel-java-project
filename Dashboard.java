import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.sql.ResultSet;

public class Dashboard extends JFrame implements ActionListener {
	String username;
	JButton addPersonalDetails,viewPersonalDetail,updatePersonDetails,checkPackages,bookPackages,viewPackage,viewHotel,bookHotel,viewBookedHotel,payments,calculators,notepad,about,deletePersonalDetail;
	Dashboard(String username){
		this.username=username;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,22,102));
		p1.setBounds(0,0,1600,65);
		add(p1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i4=new ImageIcon(i2);
		JLabel icon=new JLabel(i4);
		icon.setBounds(5,0,70,70);
		p1.add(icon);
		
		JLabel heading=new JLabel("Dashboard");
		heading.setBounds(80,10,300,40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("tahoma",Font.BOLD,30));
		p1.add(heading);
		
		JPanel p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0,65,300,900);
		add(p2);
		
		addPersonalDetails=new JButton("Add Personal Details");
		addPersonalDetails.setBounds(0,0,300,50);
		addPersonalDetails.setBackground(new Color(0,0,102));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		addPersonalDetails.setMargin(new Insets(0,0,0,60));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);
		
		updatePersonDetails=new JButton("Update Details");
		updatePersonDetails.setBounds(0,49,300,50);
		updatePersonDetails.setBackground(new Color(0,0,102));
		updatePersonDetails.setForeground(Color.WHITE);
		updatePersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		updatePersonDetails.setMargin(new Insets(0,0,0,120));
		updatePersonDetails.addActionListener(this);
		p2.add(updatePersonDetails);
		
		
		viewPersonalDetail=new JButton("View Details");
		viewPersonalDetail.setBounds(0,98,300,50);
		viewPersonalDetail.setBackground(new Color(0,0,102));
		viewPersonalDetail.setForeground(Color.WHITE);
		viewPersonalDetail.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewPersonalDetail.setMargin(new Insets(0,0,0,130));
		viewPersonalDetail.addActionListener(this);
		p2.add(viewPersonalDetail);
		
		deletePersonalDetail=new JButton("Delete Personal Details");
		deletePersonalDetail.setBounds(0,147,300,50);
		deletePersonalDetail.setBackground(new Color(0,0,102));
		deletePersonalDetail.setForeground(Color.WHITE);
		deletePersonalDetail.setFont(new Font("Tahoma",Font.PLAIN,20));
		deletePersonalDetail.setMargin(new Insets(0,0,0,50));
		deletePersonalDetail.addActionListener(this);
		p2.add(deletePersonalDetail);
		
		checkPackages=new JButton("check Packages");
		checkPackages.setBounds(0,196,300,50);
		checkPackages.setBackground(new Color(0,0,102));
		checkPackages.setForeground(Color.WHITE);
		checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		checkPackages.setMargin(new Insets(0,0,0,120));
		checkPackages.addActionListener(this);
		p2.add(checkPackages);
		
		bookPackages=new JButton("Book Package");
		bookPackages.setBounds(0,245,300,50);
		bookPackages.setBackground(new Color(0,0,102));
		bookPackages.setForeground(Color.WHITE);
		bookPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		bookPackages.setMargin(new Insets(0,0,0,110));
		bookPackages.addActionListener(this);
		p2.add(bookPackages);
		
		viewPackage=new JButton("View Package");
		viewPackage.setBounds(0,294,300,50);
		viewPackage.setBackground(new Color(0,0,102));
		viewPackage.setForeground(Color.WHITE);
		viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewPackage.setMargin(new Insets(0,0,0,110));
		viewPackage.addActionListener(this);
		p2.add(viewPackage);
		
		viewHotel=new JButton("View Hotels");
		viewHotel.setBounds(0,346,300,50);
		viewHotel.setBackground(new Color(0,0,102));
		viewHotel.setForeground(Color.WHITE);
		viewHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewHotel.setMargin(new Insets(0,0,0,115));
		viewHotel.addActionListener(this);
		p2.add(viewHotel);
		
		bookHotel=new JButton("Book Hotel");
		bookHotel.setBounds(0,394,300,50);
		bookHotel.setBackground(new Color(0,0,102));
		bookHotel.setForeground(Color.WHITE);
		bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		bookHotel.setMargin(new Insets(0,0,0,115));
		bookHotel.addActionListener(this);
		p2.add(bookHotel);
		
		viewBookedHotel=new JButton("View Book Hotel");
		viewBookedHotel.setBounds(0,442,300,50);
		viewBookedHotel.setBackground(new Color(0,0,102));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewBookedHotel.setMargin(new Insets(0,0,0,65));
		viewBookedHotel.addActionListener(this);
		p2.add(viewBookedHotel);
		
		JButton destinations=new JButton("Destination");
		destinations.setBounds(0,491,300,50);
		destinations.setBackground(new Color(0,0,102));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
		destinations.setMargin(new Insets(0,0,0,120));
		p2.add(destinations);
		
		payments=new JButton("Payment");
		payments.setBounds(0,540,300,50);
		payments.setBackground(new Color(0,0,102));
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma",Font.PLAIN,20));
		payments.setMargin(new Insets(0,0,0,150));
		payments.addActionListener(this);
		p2.add(payments);
		
		calculators=new JButton("Calculator");
		 calculators.setBounds(0,589,300,50);
		 calculators.setBackground(new Color(0,0,102));
		 calculators.setForeground(Color.WHITE);
		 calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
		 calculators.setMargin(new Insets(0,0,0,120));
		 calculators.addActionListener(this);
		p2.add(calculators);
		
		notepad=new JButton("Notepad");
		notepad.setBounds(0,638,300,50);
		notepad.setBackground(new Color(0,0,102));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
		notepad.setMargin(new Insets(0,0,0,140));
		notepad.addActionListener(this);
		p2.add(notepad);
		
		about=new JButton("About");
		about.setBounds(0,687,300,50);
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma",Font.PLAIN,20));
		about.setMargin(new Insets(0,0,0,160));
		about.addActionListener(this);
		p2.add(about);
		
		ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icons/full-shot-travel-concept-with-landmarks.jpg"));
		Image i6=i5.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
		ImageIcon i8=new ImageIcon(i6);
		JLabel image=new JLabel(i8);
		image.setBounds(0,0,1650,1000);
		add(image);
		
		JLabel text=new JLabel("Travel And Tourism Management System");
		text.setBounds(400,70,1200,70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.PLAIN,50));
		image.add(text);
		
		setVisible(true);	}
	
	    public void actionPerformed(ActionEvent ae) {
	    	if(ae.getSource()==addPersonalDetails) {
	    		new AddCustomer(username);
	    	}else if(ae.getSource()==viewPersonalDetail) {
	    		new ViewCustomer(username);
	    	}else if(ae.getSource()==updatePersonDetails) {
	    		new UpdateCustomer(username);
	    	}else if(ae.getSource()==checkPackages) {
	    		new CheckPackage();
	    	}else if(ae.getSource()==bookPackages) {
	    		new BookPackage(username);
	    	}else if(ae.getSource()==viewPackage) {
	    		new ViewPackage(username);
	    	}else if(ae.getSource()==viewHotel) {
	    		new CheckHotels();
	    	}else if(ae.getSource()==bookHotel) {
	    		new BookHotel(username);
	    	}else if(ae.getSource()==viewBookedHotel) {
	    		new ViewBookedHotel(username);
	    	}else if(ae.getSource()==payments) {
	    		new Paytm();
	    	}else if(ae.getSource()==calculators) {
	    		try {
	    			Runtime.getRuntime().exec("calc.exe");
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    	}else if(ae.getSource()==notepad) {
	    		try {
	    			Runtime.getRuntime().exec("notepad.exe");
	    			
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    	}else if(ae.getSource()==about) {
	    		new About();
	    	}else if(ae.getSource()==deletePersonalDetail) {
	    		new DeleteDetails(username);
	    	}
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


