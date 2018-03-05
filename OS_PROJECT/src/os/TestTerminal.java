
package os;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class TestTerminal {
    public static void main(String[] args) {
        Terminal term = Terminal.getInstance();
        term.open(0, 0, 700, 700);
    }
}

 class Terminal {
    private final JFrame trml = new JFrame("Terminal");			//frame of terminal
    private final JTextArea txtArea = new JTextArea();			//area of text
    private final JScrollPane scrollPane = new JScrollPane();		//Inside frame scrolling plane
    private final CommandProcessor processor = CommandProcessor.getInstance();	
    private final String LINE_SEPARATOR = System.lineSeparator();
    private final Font font = new Font("ITALIC", Font.BOLD, 15);
    private String dirstring = "/home";
    
    	//Build terminal GUI
    private Terminal() {
    	trml.setBackground(Color.BLACK);
    	
    	trml.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        trml.getContentPane().add(scrollPane);
        scrollPane.setViewportView(txtArea);
        //scrollPane.setBackground(Color.black);
    	txtArea.setBackground(Color.black);
    	
       // txtArea.setCaretColor(Color.white);
        txtArea.addKeyListener(new KeyListener());
        txtArea.setFont(font);
        txtArea.setForeground(Color.green);
        disableArrowKeys(txtArea.getInputMap());
    }

    private void disableArrowKeys(InputMap inputMap) {
        String[] keystrokeNames = { "UP", "DOWN", "LEFT", "RIGHT", "HOME" };
        for (int i = 0; i < keystrokeNames.length; ++i)
            inputMap.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
    }

    public void open(final int xLocation, final int yLocation, final int width,
            final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//trml.setBackground(Color.BLACK);
                trml.setBounds(xLocation, yLocation, width, height);
                trml.setVisible(true);
                trml.setLocation(100,50);
                showPrompt();
            }
        });
    }

    public void close() {
        trml.dispose();
    }

    public void clear() {
        txtArea.setText("");
        showPrompt();
    }

    private void showPrompt() {
        txtArea.setText(txtArea.getText() + "> ");
        
        
    }

    private void showNewLine() {
        txtArea.setText(txtArea.getText() + LINE_SEPARATOR);
    }

    private class KeyListener extends KeyAdapter {
        private final int ENTER_KEY = KeyEvent.VK_ENTER;
        private final int BACK_SPACE_KEY = KeyEvent.VK_BACK_SPACE;
        private final String BACK_SPACE_KEY_BINDING = getKeyBinding(
                txtArea.getInputMap(), "BACK_SPACE");
        private final int INITIAL_CURSOR_POSITION = 2;

        private boolean isKeysDisabled;
        private int minCursorPosition = INITIAL_CURSOR_POSITION;

        private String getKeyBinding(InputMap inputMap, String name) {
            return (String) inputMap.get(KeyStroke.getKeyStroke(name));
        }

        public void keyPressed(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == BACK_SPACE_KEY) {
                int cursorPosition = txtArea.getCaretPosition();
                if (cursorPosition == minCursorPosition && !isKeysDisabled) {
                    disableBackspaceKey();
                } else if (cursorPosition > minCursorPosition && isKeysDisabled) {
                    enableBackspaceKey();
                }
            } else if (keyCode == ENTER_KEY) {
                disableTerminal();
                String command = extractCommand();
                executeCommand(command);
                showNewLine();
                showPrompt();
                enableTerminal();
            }
        }

        public void keyReleased(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == ENTER_KEY) {
                txtArea.setCaretPosition(txtArea.getCaretPosition() - 1);
                setMinCursorPosition();
            }
        }

        private void disableBackspaceKey() {
            isKeysDisabled = true;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    "none");
        }

        private void enableBackspaceKey() {
            isKeysDisabled = false;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    BACK_SPACE_KEY_BINDING);
        }

        private void setMinCursorPosition() {
            minCursorPosition = txtArea.getCaretPosition();
        }
    }
    
    public void enableTerminal() {
        txtArea.setEnabled(true);
    }

    public void disableTerminal() {
        txtArea.setEnabled(false);
    }
    
    private void executeCommand(String command) {
       // processor.processCmd(command);
       
       // breaking the command in two parts
       String firstcommand="";
       String secondcommand="";
       for(int i=0;i < command.length();i++)
       {
           if( command.charAt(i)==' ')
           {
               firstcommand=command.substring(0,i);
               secondcommand=command.substring(i+1,command.length());
               break;
           }
           if(i==command.length()-1)
           {
               firstcommand=command;
               secondcommand="";
               break;
           }
       }
       
       //System.out.println(firstcommand + " " + secondcommand);
       
       //done 
		       if ("cd".equals(firstcommand) && ("".equals(secondcommand))){
		           txtArea.append("\nNow in home directory");
		            dirstring = "/home";
		           // txtArea.append("/home>");
		           
		           
		       }
		       else if("cd".equals(firstcommand) && (".".equals(secondcommand)))
		       {
		           //change the dirstring 
		           if ("/home".equals(dirstring))
		                   {
		                       txtArea.append("\nYou are already in home");
		                   }
		                       
		           else{
		                   
		           for(int i=dirstring.length()-1;i>=0;i--)
		           {
		               if(dirstring.charAt(i)=='/') {
		                   dirstring=dirstring.substring(0,i);
		                   break;
		               }
		           }txtArea.append("\nyou are here"+dirstring);
		       }
		       }
		       else if ("cd".equals(firstcommand)&& (!("".equals(secondcommand))))
		               {
		                   Path p1 = Paths.get(dirstring+"/"+secondcommand); 
		                    if (Files.notExists(p1)) {
		               txtArea.append("\npath doesnot exist");
		               
		           }
		                    else{
		                   dirstring=dirstring+"/"+secondcommand;
		                   txtArea.append("\nyou are here "+dirstring);
		               }
		               }
		       else if("ls".equals(firstcommand)){ 
				      txtArea.append(dirstring);// make provision of second command as well
				          
				       File folder = new File(dirstring);
				        File[] listOfFiles = folder.listFiles();
				        int num = listOfFiles.length;
				        System.out.println(num);
					    for(int i = 0; i < num; i++) {
					      if (listOfFiles[i].isFile()) {
					        System.out.println("File " + listOfFiles[i].getName());
					        txtArea.append("\nFile " + listOfFiles[i].getName());
					      } else if (listOfFiles[i].isDirectory()) {
					        System.out.println("Directory " + listOfFiles[i].getName());
					        txtArea.append("\nDirectory " + listOfFiles[i].getName());
					      }
					    }
		       		}
		       else if("clear()".equals(firstcommand)){
		    	   clear();
		       }
		       else if("close()".equals(firstcommand)){
		    	   close();
		       }
		       else  if("mkdir".equals(firstcommand)){
				       File dir = new File(secondcommand);
				    
				    // attempt to create the directory here
				    boolean successful = dir.mkdir();
				    if (successful)
				    {
				      // creating the directory succeeded
				      System.out.println("directory was created successfully");
				      txtArea.append("\ndirectory was created successfully");
				    }
				    else
				    {
				      // creating the directory failed
				      System.out.println("failed trying to create the directory");
				      txtArea.append("\nfailed trying to create the directory");
				    }
				       }
				       
				       else if("rm".equals(firstcommand))
				       {
				           try{
				
				    		File file = new File(secondcommand);
				
				    		if(file.delete()){
				    			System.out.println(file.getName() + " is deleted!");
				                        txtArea.append("\n"+file.getName() + " is deleted!");
				    		}else{
				    			System.out.println("Delete operation is failed.");
				                        txtArea.append("\nDelete operation is failed.");
				    		}
				
				    	}catch(Exception e){
				
				    		e.printStackTrace();
				       }
				       }
				       else if("add".equals(firstcommand)){
				    	try{
				    		String[] arr = secondcommand.split(" ");
				    	   int[] arr2 = new int[arr.length];
				    	   for(int i=0;i< arr2.length;i++)
				    		    arr2[i] = 0;
				    	   int sum = 0;
				    	   for(int i=0;i<arr.length;i++){
				    		   arr2[i]  = Integer.parseInt(arr[i]);
				    	   }
				    	   for(int i = 0;i< arr2.length;i++){
				    		   sum = sum + arr2[i];
				    	   }
				    	   String str = Integer.toString(sum);
				    	   txtArea.append("\n");
				    	   txtArea.append(str +"\n");
				       }
				    	   catch(Exception e){
				    		   txtArea.append("\n");
					    	   txtArea.append("Wrong Formatd\n");
				    	   }
				       }
				       else if("sub".equals(firstcommand)){
				    	   try{ 
				    	   String[] arr = secondcommand.split(" ");
				    	   int[] arr2 = new int[arr.length];
				    	   for(int i=0;i< arr2.length;i++)
				    		    arr2[i] = 0;
				    	   int sub ;
				    	   for(int i=0;i<arr.length;i++){
				    		   arr2[i]  = Integer.parseInt(arr[i]);
				    	   }
				    	   sub = arr2[0];
				    	   for(int i = 1;i< arr2.length;i++){
				    		   sub = sub - arr2[i];
				    	   }
				    	   String str = Integer.toString(sub);
				    	   txtArea.append("\n");
				    	   txtArea.append(str +"\n");
				    	   }
				    	   catch(Exception e){
				    		   txtArea.append("\n");
					    	   txtArea.append("Wrong Formatd\n");
				    	   }
				    }
	       			//another command 
				       else if("cat".equals(firstcommand))
				      {
				       String fname;
				       fname = secondcommand;
				        
				        /* this will reference only one line at a time */
				        
				        String line = null;
				        try
				        {
				            /* FileReader reads text files in the default encoding */
				            //FileReader fileReader = new FileReader(fname);
				            
				            /* always wrap the FileReader in BufferedReader */
				            //
				            //BufferedReader bufferedReader = new BufferedReader(fileReader);
				            BufferedReader bufferedReader= new BufferedReader(new FileReader(dirstring+"/"+secondcommand));
				            txtArea.append("\n");
				            while((line = bufferedReader.readLine()) != null)
				            {
				                System.out.println(line);
				                txtArea.append(line+"\n");
				            }
				            
				            /* always close the file after use */
				            bufferedReader.close();
				        }
				        catch(IOException ex)
				        {
				            System.out.println("Error reading file named '" + fname + "'");
				        }
				       
					   }
			   // another command 
			       
			       else if("touch".equals(firstcommand))
			       {
			            File file = new File(secondcommand);
			             boolean blnCreated = false;
			     try
			     {
			       blnCreated = file.createNewFile();
			       
			           
			     }
			     catch(IOException ioe)
			     {
			       System.out.println("Error while creating a new empty file :" + ioe);
			     }
			     if(blnCreated==true)
			     {
			     System.out.println("file " + file.getPath() + " creation  success  ");
			      txtArea.append("\nfile " + file.getPath() + " creation  success  ");
			     
			     }
			     else{
			        System.out.println("file " + file.getPath() + " creation  failed ");
			     txtArea.append("\nfile " + file.getPath() + " creation  failed  ");
			       }
			       }
			       //another command
			       else if("run".equals(firstcommand))
			       {
			            if ("Notepad".equals(secondcommand)){ Notepad.main(null);
			            		txtArea.append("\nNotepad opened");}
			            else  if ("Manager".equals(secondcommand)) {OpenFile.main(null);
			                    txtArea.append("\nManager opened");}
			            else if ("Calendar".equals(secondcommand)){ calendarprogra.main(null);
			                    txtArea.append("\nCalendar opened");}
			            else if ("Calculator".equals(secondcommand)){ SimpleCalc.main(null);
			            		txtArea.append("\nSimple Calculator opened");}
			            else if ("Image Viewer".equals(secondcommand)){ ImageViewer.main(null);
			            		txtArea.append("\nImage Viewer opened");}
			            else if ("PinBall".equals(secondcommand)){ pinball.main(null);
	            				txtArea.append("\nPinball Game opened");}
			            else if ("Clock".equals(secondcommand)){ ClockGui.main(null);
        				txtArea.append("\nClock opened");}
			            else {
			            	txtArea.append("\n File not found");
			            }
			       }
			       //custom commands
			       else if("quit".equals(firstcommand))
			       {
			           trml.dispose();
			       }
			           
			       else if("pwd".equals(firstcommand))
			               {
			               System.out.println("Working Directory = " +
			              System.getProperty("user.dir"));
			               txtArea.append("\nWorking Directory = " +
			              System.getProperty("user.dir"));
			           
			               }
			       else {
			           System.out.println("wrong command");
			           txtArea.append("\nwrong command");
			          
			       }
			       
			    }

    private String extractCommand() {
        removeLastLineSeparator();
        String newCommand = stripPreviousCommands();
        System.out.println("success" + newCommand);
        return newCommand;
    }

    private void removeLastLineSeparator() {
        String terminalText = txtArea.getText();
        terminalText = terminalText.substring(0, terminalText.length() - 1);
        txtArea.setText(terminalText);
        
    }

    private String stripPreviousCommands() {
        String terminalText = txtArea.getText();
        int lastPromptIndex = terminalText.lastIndexOf('>') + 2;
        if (lastPromptIndex < 0 || lastPromptIndex >= terminalText.length())
            return "";
        else
            return terminalText.substring(lastPromptIndex);
    }

    public static Terminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    private static final class TerminalHolder {
        static final Terminal INSTANCE = new Terminal();
    }
}

class CommandProcessor {
    private CommandProcessor() {
    }

    public void processCmd(String command) {
        System.out.println("User command: " + command);
    }

    public static CommandProcessor getInstance() {
        return CommandProcessorHolder.INSTANCE;
    }

    private static final class CommandProcessorHolder {
        static final CommandProcessor INSTANCE = new CommandProcessor();
    }
}