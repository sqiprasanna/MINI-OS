package os;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class pinball
{
public static void main(String[] args)
{

JFrame frame = new JFrame();


frame.setSize(600,780);


frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


Panel00 panel = new Panel00();

frame.add(panel);



frame.setVisible(true);

}
	
}