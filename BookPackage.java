import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BookPackage extends JFrame implements ActionListener {
	Choice cpackage;
	JTextField tfperson;
	String username;
	JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
	JButton checkprice,bookpackage,back;
	BookPackage(String username){
		this.username=username;
		setBounds(350,200,1100,500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text=new JLabel("BOOK PACKAGE");
		text.setBounds(100,10,200,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		JLabel lblusername=new JLabel("Username");
		lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblusername.setBounds(40,70,100,20);
		add(lblusername);
		
		labelusername=new JLabel();
		labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		labelusername.setBounds(250,70,200,20);
		add(labelusername);
		
		JLabel lblpackage=new JLabel("Select Package");
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40,110,150,20);
		add(lblpackage);
		
		cpackage=new Choice();
		cpackage.add("Gold Package");
		cpackage.add("Silver Package");
		cpackage.add("Bronze Package");
		cpackage.setBounds(250,110,200,20);
		add(cpackage);
				
		
		JLabel lblperson=new JLabel("Total Person");
		lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblperson.setBounds(40,150,150,25);
		add(lblperson);
		
		tfperson=new JTextField("1");
		tfperson.setBounds(250,150,200,25);
		add(tfperson);
		
		JLabel lblid=new JLabel("Id");
		lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblid.setBounds(40,190,200,25);
		add(lblid);
		
		labelid=new JLabel();
		labelid.setBounds(250,190,150,25);
		add(labelid);
		
		JLabel lblnumber=new JLabel("Number");
		lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblnumber.setBounds(40,230,150,25);
		add(lblnumber);
		
		labelnumber=new JLabel();
		labelnumber.setBounds(250,230,150,25);
		add(labelnumber);
		
		JLabel lblphone=new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblphone.setBounds(40,270,150,25);
		add(lblphone);
		
	    labelphone=new JLabel();
		labelphone.setBounds(250,270,200,25);
		add(labelphone);
		
		JLabel lblprice=new JLabel("Total Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(40,310,150,25);
		add(lblprice);
		
		labelprice=new JLabel();
		labelprice.setBounds(250,310,150,25);
		add(labelprice);
		
		 try {
		    	Conn conn= new Conn();
		        String query= "select * from customer where username = '"+username+"'";
		    	ResultSet rs=conn.s.executeQuery(query);
		        while(rs.next()) {
		        	labelusername.setText(rs.getString("username"));
		        	labelid.setText(rs.getString("id"));
		        	labelnumber.setText(rs.getString("number"));
		        	labelphone.setText(rs.getString("phone"));
		        	
		        }
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		 
		 checkprice=new JButton("Check Price");
		 checkprice.setBackground(Color.BLACK);
		 checkprice.setForeground(Color.WHITE);
		 checkprice.setBounds(60,380,120,25);
		 checkprice.addActionListener(this);
		 add(checkprice);
		 
		 bookpackage=new JButton("Book Package");
		 bookpackage.setBackground(Color.BLACK);
		 bookpackage.setForeground(Color.WHITE);
		 bookpackage.setBounds(200,380,120,25);
		 bookpackage.addActionListener(this);
		 add(bookpackage);
		 
		 back=new JButton("Back");
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE);
		 back.setBounds(340,380,120,25);
		 back.addActionListener(this);
		 add( back);
		 
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
			Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
			ImageIcon i4=new ImageIcon(i2);
			JLabel l15=new JLabel(i4);
			l15.setBounds(550,50,500,300);
			add(l15);
		 
		 
		 setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==checkprice) {
			String pack=cpackage.getSelectedItem();
			int cost=0;
			if(pack.equals("Gold Package")) {
				cost+=12000;
			}else if(pack.equals("Silver Package")) {
				cost +=25000;
			}else {
				cost +=32000;
			}
			
			int person =Integer.parseInt(tfperson.getText());
			cost *=person;
			labelprice.setText("Rs" +cost);
			
		}else if(ae.getSource()==bookpackage) {
			try {
				Conn c=new Conn();
				c.s.executeUpdate("insert into bookpackage value('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}
	

	public static void main(String[] args) {
	    try {
	        Conn c = new Conn();
	        ResultSet rs = c.s.executeQuery("SELECT username FROM bookpackage LIMIT 1"); // or use FETCH FIRST 1 ROWS ONLY for some DBs
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
