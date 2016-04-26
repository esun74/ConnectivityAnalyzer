/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivityanalyzer;

import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class ConnectivityAnalyzer {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // pretty standard gui things
        ConnectivityFrame frame = new ConnectivityFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }
    
}
