package os;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame {

public static void main(String[] args) {
Log frameTabel = new Log();
}

JButton blogin = new JButton("Login");		//create a button;
JPanel panel = new JPanel();				//creating a Frame or panel;

JTextField username = new JTextField("",15);		//UserName 
//JButton asd = new JButton("asd");
JPasswordField pass = new JPasswordField("", 15); //password


Log(){
super("Login Authentication");
setSize(500,300);				// size of panel
setLocation(600,280);			//location of panel on screen
panel.setLayout (null);			

//asd.setBounds(0,0,150,20);
username.setBounds(180,83,150,20);		//setBounds(x, y, width, height) where (x,y) are  coordinate of the upper-left corner of that component
pass.setBounds(180,114,150,20);
//blogin.setBackground(Color.GRAY);
blogin.setBounds(146,155,80,20);
//panel.add(asd);
panel.add(blogin);				//Appends the specified component to the end of this container
panel.add(username);
panel.add(pass);
panel.setBackground(Color.black);
/*asd.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent evt){
		Desktop.main(null);
	}
});*/
getContentPane().add(panel);
JLabel lblUsername = new JLabel("UserName:-");
lblUsername.setBounds(65, 79, 74, 29);
lblUsername.setForeground(Color.white);
panel.add(lblUsername);
JLabel lblPassword = new JLabel("Password:-");
lblPassword.setBounds(64, 116, 65, 17);
lblPassword.setForeground(Color.white);
panel.add(lblPassword);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//on exit close the Login form
setVisible(true);
actionlogin();
}

//login action for user

public void actionlogin(){
	blogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		    
		String puname = username.getText();
		String ppaswd = pass.getText();
			if(puname.equals("MINI OS") && ppaswd.equals("MINI OS")) {
			
				Desktop.main(null);				//In this line we call main function in other.java if user name and password are correct
				dispose();
			} 
			else if(puname.equals("MINI OS") && ppaswd != "MINI OS" ){
				JOptionPane.showMessageDialog(null,"Wrong Password");
			}
			else if(puname != "MINI OS" && ppaswd.equals("MINI OS") ){
				JOptionPane.showMessageDialog(null,"Wrong Username");
			}
			else {
				JOptionPane.showMessageDialog(null,"Wrong Password and Username");
				username.setText("Enter User name ");
				pass.setText("Password");
				username.requestFocus();
			}

		}
});
}
}
