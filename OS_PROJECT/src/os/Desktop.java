
package os;


import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.*;
import java.io.File;
public class Desktop extends javax.swing.JFrame {

    private JButton powerbutton;
	public Desktop() {
		setTitle("MINI OS");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("/images/background1.jpg"));
		getContentPane().setBackground(new Color(153, 180, 209));
		
		setContentPane(new JLabel(new ImageIcon(getClass().getResource("/images/background3.jpeg"))));
		
		initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	powerbutton = new javax.swing.JButton();
        calendar = new javax.swing.JButton();
        imgviewer = new javax.swing.JButton();
        calculator = new javax.swing.JButton();
        game = new javax.swing.JButton();
        clock = new javax.swing.JButton();
        filemanager = new javax.swing.JButton();
        notepad = new javax.swing.JButton();
        trmnl = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.darkGray);
        setPreferredSize(new Dimension(1200, 760));
        setLocation(150,50);
       powerbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power button.jpeg")));
         powerbutton.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		jButton1ActionPerformed(evt);
        	}
        });
  //       calendar.setSize(64,70);
        calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calender.png"))); // NOI18N
        calendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        imgviewer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imageviewer.jpeg"))); // NOI18N
     
        imgviewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
      
        calculator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calci.png"))); // NOI18N
       
        calculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        game.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinball.png"))); // NOI18N
       
        game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.jpeg"))); // NOI18N
       
        clock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        
        
        trmnl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/terminal.png"))); // NOI18N
        
         trmnl.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton2ActionPerformed(evt);
             }
         });
        
                notepad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notepad.png"))); // NOI18N
                
                notepad.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton5ActionPerformed(evt);
                    }
                });
        
                filemanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filemanager.jpeg"))); // NOI18N
                
                filemanager.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton4ActionPerformed(evt);
                    }
                });
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(436, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(trmnl)
        				.addComponent(calculator))
        			.addGap(50)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(imgviewer)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(game)))
        			.addGap(50)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(clock, 0, 0, Short.MAX_VALUE)
        				.addComponent(calendar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(50)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(notepad, Alignment.TRAILING)
        				.addComponent(filemanager, Alignment.TRAILING))
        			.addContainerGap(455, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(1410, Short.MAX_VALUE)
        			.addComponent(powerbutton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        			.addGap(50))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(powerbutton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        			.addGap(360)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(trmnl)
        				.addComponent(notepad)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(imgviewer)
        						.addComponent(clock))
        					.addGap(36)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(filemanager)
        						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        							.addComponent(game)
        							.addComponent(calendar)
        							.addComponent(calculator)))))
        			.addContainerGap(861, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
            Notepad.main(null);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ImageViewer.main(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        SimpleCalc.main(null);
    }//GEN-LAST:event_jButton8ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TestTerminal.main(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        calendarprogra.main(null);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        OpenFile.main(null);
    }//GEN-LAST:event_jButton4ActionPerformed

   private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        ClockGui.main(null);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    	pinball.main(null);
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desktop().setVisible(true);
               // setSize(719,768);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clock;
    private javax.swing.JButton trmnl;
    private javax.swing.JButton calendar;
    private javax.swing.JButton filemanager;
    private javax.swing.JButton notepad;
    private javax.swing.JButton imgviewer;
    private javax.swing.JButton calculator;
    private javax.swing.JButton game;
}
