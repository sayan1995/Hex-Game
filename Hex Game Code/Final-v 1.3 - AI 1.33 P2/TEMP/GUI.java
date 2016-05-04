import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class GUI  {
    // Global Variables
    JFrame frame = new JFrame(); // Creates JFrame
    JLabel title;
    final JToggleButton l[][]; // Names grid of JButtons
    JPanel panel;
    JButton done;
    private static Icon res = (UIManager.getIcon("OptionPane.errorIcon"));
    
    static int y,x;
    int d=0;
    // Constructor
    public GUI()throws IOException{
        
        
        frame.setLayout(null); // Setting Grid Layout
        // panel1.setLayout(new GridLayout(seat,row));
        l = new JToggleButton[11][11]; // Allocating Size of Grid
        panel = new JPanel(new GridLayout(11,11));
        panel.setBackground(Color.black);
        panel.setBounds(90, 110, 660, 330);
        selected();
        frame.add(panel);
        frame.setPreferredSize(new Dimension(880, 580));
        frame.setTitle("HEX GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
        
      }  
    public void selected()
    {
        
        for(y = 0; y <11 ; y++){
            for(x = 0; x < 11; x++){

                            l[y][x] = new JToggleButton(y+","+x);
                            
                            l[y][x].addActionListener(new ActionListener() {
                                
                                
                                public void actionPerformed(ActionEvent actionEvent) {
                                    AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                                    boolean selected = abstractButton.getModel().isSelected();
                                    
                                    if (selected) {
                                        
                                        //l[x][y].setIcon(res);
                                        abstractButton.setIcon(res);
                                           
                                    } else {
                                        d--;
                                        abstractButton.setIcon(null);
                                        //
                                        
                                        
                                    }
                                }
                                
                            });
                        
                        
                        
                        // Creates New JButton
                        // l[x][y].addActionListener(this);
                        panel.add(l[y][x]); //adds button to grid

                }
                
            }
            
            
            
        }
        
      public static void main(String[] args)throws IOException {
            
            
            EventQueue.invokeLater(new Runnable() {
                
                
                public void run() {
                    try
                    {
                        new GUI();
                    }
                    catch (IOException e)
                    {
                        
                    }

                }
            });
            
            //makes new ButtonGrid with 2 parameters
        }
        }