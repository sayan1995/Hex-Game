import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/** @see http://stackoverflow.com/questions/6333464 */
public class temp extends JPanel {
	    static int y,x;
    int d=0;
private static Icon res = (UIManager.getIcon("OptionPane.errorIcon"));
 final JToggleButton l[][];
    public temp() {
    	
    	l=new JToggleButton[11][11]; 
        //this.add(new JLabel("Hello World!", JLabel.CENTER));
        this.add(new JPanel(new GridLayout(11,11,0,0)));
        //this.setBackground(Color.black);
        this.setSize(800, 800);
       
        selected();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w2 = getWidth() / 2;
        int h2 = getHeight() / 2;
        g2d.rotate(Math.PI / 4, w2, h2);
        super.paintComponent(g);
    }

    private void display() {
        JFrame f = new JFrame("temp");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.setPreferredSize(new Dimension(1000, 1000));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
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
                        this.add(l[y][x]); //adds button to grid

                }
                
            }
            
            
            
        }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {


            	  public void run() {
                new temp().display();
            }
        });
    }
    }