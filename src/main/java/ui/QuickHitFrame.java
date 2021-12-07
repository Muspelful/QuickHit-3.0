package main.java.ui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.Constants;
import main.java.SavedSkillManager;

public class QuickHitFrame extends JFrame {

    /**
     * Default constructor. Sets up a frame for an instance of QuickHit.
     */
    public QuickHitFrame() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        initUnits();
        initChainPanel();
        initMacroPanel();
        
        new SavedSkillManager();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuickHit");
        this.pack();
        this.setVisible(true);
    }

    /**
     * Initiates the unit panel.
     */
    private void initUnits() {
        JPanel unitsPanel = new JPanel();
        this.add(unitsPanel);
        for(int count = 1; count <= Constants.MAX_NUMBER_OF_UNITS; count++) {
            unitsPanel.add(new UnitPanel(count));
        }
    }

    /**
     * Initiates the chain panel.
     */
    private void initChainPanel() {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Initiates the macro panel.
     */
    private void initMacroPanel() {
        // TODO Auto-generated method stub
        
    }
}
