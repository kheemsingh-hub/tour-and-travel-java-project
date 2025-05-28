import java.awt.Image;

import javax.swing.*;

public class Splash extends JFrame implements Runnable {
	Thread thread;
    Splash() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Correct way to load image (Ensure splash.jpg is in icons/ inside classpath)
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icons/splash.jpg"));
        Image img2=img.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon img4=new ImageIcon(img2);
        
        JLabel label = new JLabel(img4);
        add(label);

        setVisible(true); // Set visible after adding components
        thread =new Thread();
        thread.start();
    }
    public void run() {
    	try {
    		Thread.sleep(8000);
    		//new Login();
    	    setVisible(false);
    	} catch(Exception e) {
    		
    	}
    	
    }

    public static void main(String[] args ) {
        Splash frame=new Splash();
        int x=1;
        for(int i = 1; i<=500; x+=7 ,i+=6){
        	frame.setLocation(750 - (i+i)/2 ,400 -(i/2));
        	frame.setSize(x+i ,  i);
        	
        	try {
        		Thread.sleep(10);
        	} catch (Exception e) {}
        }
		      
    }
}

	
