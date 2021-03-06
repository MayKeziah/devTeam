/**
 * 
 */
package display;

/******************************************************************************************************************************************
 * This class defines a basic calculator application which is able to perform simple mathematical operations including:
 *  > Addition
 *  > Subtraction
 *  > Multiplication
 *  > Division
 *  
 *  <p>
 *  This was written as the culminating project for the Project Development division of the scc.devTeam( ), a branch of the
 *  Computer Science and Engineering Club (CSEC) at Seattle Central College (SCC) in Spring 2019.
 *  
 *  <p>
 *  This project was proposed on April 29th, 2019 and it's first launch was June 3rd, 2019 after only 5 hours of meetings.
 *   
 *  <p>
 *  Both members of the front end team, Christina and Yong, had completed one programming course, CSC110: "Intro to Programming: Python",
 *  and they were enrolled in CSC142: "Computer Programming I: Java"
 *  Michael of the back end team had completed CSC110, CSC142, and was enrolled in "Computer Programming II: Java"
 *  Keziah of the back end team had completed CSC110, CSC142, CSC143, and was a TA for CSC142, 
 *  Programming and Professional Development Coordinator for the CSEC, and founder/organizer of the scc.devTeam( )
 *  
 *
 * @author scc.devTeam( ) Contributers: Front End: Christina McMahon, and Yong Long Tan, Back End: Keziah May, and Michael Rogers
 * @version Spring 2019
 ******************************************************************************************************************************************/
import javax.swing.*;

import buttonControls.InputParser;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Calculator extends JFrame
{
    /**
     * The input/output display area
     */
	private JTextArea display; 

	/**
	 * The numerical buttons
	 */
    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    
    /**
     * Misc. helper buttons
     */
    private JButton decimal;
    private JButton posneg;
    private JButton clear;
    private JButton equal;
    private JButton backspace;

    /**
     * Operator buttons
     */
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;

    /**
     * Options menu fields
     */
    private JMenuBar 	menuBar;
    private JMenu 		file;
    private JMenu 		edit;
    private JMenu 		help;
    private JMenuItem 	close;
    private JMenuItem 	copy;
    private JMenuItem 	darkMode;
    private JMenuItem 	lightMode;
    private JMenuItem 	about;
//  private JMenuItem 	view;

    
    /**
     * String to be displayed when people select the "About Calculator" menu item
     */
    private String aboutInfo = 
    		"   This was written as the culminating project for the Project Development division of the scc.devTeam( ), a branch of the\r\n" + 
    		"   Computer Science and Engineering Club (CSEC) at Seattle Central College (SCC) in Spring 2019.\r\n" + 
    		"   \r\n" + 
    		"   This project was proposed on April 29th, 2019 and it's first launch was June 3rd, 2019 after only 5 hours of meetings.\r\n" + 
    		"   \r\n" + 
    		"   Front End:\r\n" +
    	 	"   Christina and Yong, had completed one programming course, CSC110: \"Intro to Programming: Python\",\r\n" + 
    		"   and they were enrolled in CSC142: \"Computer Programming I: Java\"\r\n" + 
    	 	"   Back End:\r\n" +
    		"   Michael of the back end team had completed CSC110, CSC142, and was enrolled in \"Computer Programming II: Java\"\r\n" + 
    		"   Keziah of the back end team had completed CSC110, CSC142, CSC143, and was a TA for CSC142, \r\n" + 
    		"   Programming and Professional Development Coordinator for the CSEC, and founder/organizer of the scc.devTeam( )\r\n" + 
    		"   \r\n" + 
    		"   \r\n" + 
    		"   scc.devTeam( ) Contributers: \r\n" +
    		"   Front End: Christina McMahon, and Yong Long Tan, \r\n" +
    		"   Back End: Keziah May, and Michael Rogers\r\n" + 
    		"   version: v.1 Spring 2019";

    
    
    
    
    /***************************************************************************************************************
     * When run, this opens the default calculator application.
     * 
     * @param args
     ***************************************************************************************************************/
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch(Exception e) {
            System.out.println("Could not load System look.");
        }
        new Calculator();
    }

    
    
    
    
    /***************************************************************************************************************
     * Constructs a default calculator
     ***************************************************************************************************************/
    public Calculator() {
        super("Calculator");
        sendMenuBar();
        setDisplay();
        setButtons();
        sendUI(this);
    }

    
    
    
    
    /***************************************************************************************************************
     * Defines the appearance of the menu/options bar
     ***************************************************************************************************************/
    private void sendMenuBar() {
        menuBar = new JMenuBar();
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu(" Help ");
        close = new JMenuItem("Close");
        copy = new JMenuItem("Copy");
        darkMode = new JMenuItem("Dark Mode");
        lightMode = new JMenuItem("Light Mode");
        about = new JMenuItem("About Calculator");
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        /**
         * When you click the Close button from the file menu, the application window closes and operations are terminated
         */
        close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });

        /**
         * Copies the content of the display window to the clipboard.
         * 
         * TODO: copy display to clipboard
         */
        copy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String display = "";
                    StringSelection string = new StringSelection(display);
                    Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
                    system.setContents(string, string);
                }
            });

        /**
         * Opens a window with information about this calculator.
         * 
         * TODO: revise appearance of 'about' pop-up
         */
        about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, aboutInfo,
                        "Calculator", JOptionPane.OK_OPTION);
                }
            });

        file.add(close);
        edit.add(copy);
        edit.add(darkMode);
        edit.add(lightMode);
        help.add(about);
    }

    
    
    
    
    /***************************************************************************************************************
     * Defines the appearance of the input/output display box
     ***************************************************************************************************************/
    private void setDisplay() {
        display = new JTextArea();

        //create a white bar
        display.setBounds(10, 10, 280, 50);
        display.setEditable(false);

        //make the numbers display at the right side of the bar
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);        
        display.setText("0");

        //edit the style of the font
        display.setFont(new Font("Arial",Font.PLAIN,32));
        add(display);
    }

    
    
    
    
    /***************************************************************************************************************
     * Defines the display text of buttons and their functionality.
     ***************************************************************************************************************/
    private void setButtons() {
    	
    	/********************************************************
    	 * Numerical Buttons:
    	 ********************************************************/
        zero = new JButton("0");
        zero.setBounds(82,256,65,55);
        zero.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("0");
                        return;
                    }
                    display.append("0");
                }
            });
        add(zero);

        one = new JButton("1");
        one.setBounds(10,194,65,55);
        one.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("1");
                        return;
                    }
                    display.append("1");
                }
            });
        add(one);

        two = new JButton("2");
        two.setBounds(82,194,65,55);
        two.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("2");
                        return;
                    }
                    display.append("2");
                }
            });
        add(two);

        three = new JButton("3");
        three.setBounds(154,194,65,55);
        three.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("3");
                        return;
                    }
                    display.append("3");
                }
            });
        add(three);

        four = new JButton("4");
        four.setBounds(10,132,65,55);
        four.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("4");
                        return;
                    }
                    display.append("4");
                }
            });
        add(four);

        five = new JButton("5");
        five.setBounds(82,132,65,55);
        five.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("5");
                        return;
                    }
                    display.append("5");
                }
            });
        add(five);

        six = new JButton("6");
        six.setBounds(154,132,65,55);
        six.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("6");
                        return;
                    }
                    display.append("6");
                }
            });
        add(six);

        seven = new JButton("7");
        seven.setBounds(10,70,65,55);
        seven.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("7");
                        return;
                    }
                    display.append("7");
                }
            });
        add(seven);

        eight = new JButton("8");
        eight.setBounds(82,70,65,55);
        eight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("8");
                        return;
                    }
                    display.append("8");
                }
            });
        add(eight);

        nine = new JButton("9");
        nine.setBounds(154,70,65,55);
        nine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (display.getText().length() > 13)
                        return;
                    if (display.getText().equalsIgnoreCase("0")) {
                        display.setText("9");
                        return;
                    }
                    display.append("9");
                }
            });
        add(nine);

        
        
        
    	/********************************************************
    	 * Misc. Helper Buttons:
    	 ********************************************************/
        decimal = new JButton(".");
        decimal.setBounds(10,256,65,55);
        add(decimal);

        posneg = new JButton("+/-");
        posneg.setBounds(154,256,65,55);
        add(posneg);
        

        clear = new JButton("C");
        clear.setBounds(154,318,65,55);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
            }
        });
        add(clear);

        equal = new JButton("=");
        equal.setBounds(10,318,137,55);
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")) {
                    display.setText("0");
                    return;
                }
                display.setText(InputParser.parse(display.getText()));
            }
        });
        add(equal);

        backspace = new JButton("\u232b");
        backspace.setBounds(226,316,65,55);
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")) {
                    display.setText("0");
                    return;
                }
                display.setText((display.getText().substring(0, display.getText().length()-1)));
            }
        });
        
        add(backspace);
        
        
        
        
    	/********************************************************
    	 * Operator Buttons:
    	 ********************************************************/
        addition = new JButton("+");
        addition.setBounds(226,70,65,55);
        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")) {
                    display.setText("0");
                    return;
                }
                display.append("+");
            }
        });
        add(addition);

        subtraction = new JButton("-");
        subtraction.setBounds(226,132,65,55);
        subtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")) {
                    display.setText("0");
                    return;
                }
                display.append("-");
            }
        });
        add(subtraction);

        multiplication = new JButton("x");
        multiplication.setBounds(226,194,65,55);
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")) {
                    display.setText("0");
                    return;
                }
                display.append("x");
            }
        });
        add(multiplication);

        division = new JButton("�");
        division.setBounds(226,254,65,55);
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")) {
                    display.setText("0");
                    return;
                }
                display.append("/");
            }
        });
        add(division);
    }
    
    
    
    
    

    /***************************************************************************************************************
     * Defines the UI for your calculator
     * 
     * @param app
     ***************************************************************************************************************/
    private void sendUI(Calculator app) {
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(307,443);
        app.setResizable(false);
        app.setLayout(null);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}


