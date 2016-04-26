/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivityanalyzer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class ConnectivityFrame extends JFrame {
    private final Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    private final JComboBox userSelection = new JComboBox(values);
    private final JPanel northernPanel = new JPanel();
    private final JPanel centralPanel = new JPanel();
    private final ArrayList<JTextField> spaces = new ArrayList();
    
    ConnectivityFrame() {
        super("Testing for Connectivity");
        
        // puts the panels in their place
        add(northernPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        
        // adds an ActionListener for the combo box so whenever the number changes the grid changes as well
        userSelection.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent event) {
                
                // remove things
                centralPanel.removeAll();
                centralPanel.repaint();
                centralPanel.revalidate();
                spaces.clear();
                
                // creates the grid
                GridLayout x = new GridLayout(userSelection.getSelectedIndex() + 1, userSelection.getSelectedIndex() + 1);
                centralPanel.setLayout(x);
                int number = (userSelection.getSelectedIndex() + 1)*(userSelection.getSelectedIndex() + 1);
                for (int i = 0; i < number; i++) {
                    spaces.add(new JTextField());
                    spaces.get(i).setText("0");
                    spaces.get(i).setHorizontalAlignment(JLabel.CENTER);
                    centralPanel.add(spaces.get(i));
                }
            }
        });
        
        // a container for the top elements
        Box container = new Box(BoxLayout.LINE_AXIS);
        JLabel instructions = new JLabel("Please enter your adjacency matrix.");
        JButton activator = new JButton("Check");
        
        // what to do if the button is pressed
        activator.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent even) {
                
                // if it's an adjacency matrix with one node why bother
                if (userSelection.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "This graph is connected!");
                    return;
                }
                
                // parses the user input calls analyzeGraph
                int size = userSelection.getSelectedIndex() + 1;
                int number = size*size;
                int[] matrix = new int[number];
                try {
                    for (int i = 0; i < number; i++) 
                        matrix[i] = Integer.parseInt(spaces.get(i).getText());
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "You didn't enter a number!");
                    return;
                }
                JOptionPane.showMessageDialog(null, Graph.analyzeGraph(size, matrix) ? "This graph is connected!" : "This graph isn't connected!");
            }
        });
        
        // puts them all nicely into their respective containers
        container.add(instructions);
        container.add(Box.createHorizontalStrut(10));
        container.add(userSelection);
        container.add(Box.createHorizontalStrut(10));
        container.add(activator);
        northernPanel.add(container);
        
    }
}
