package main.java.ui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.Constants;
import main.java.SavedSkillManager;
import main.java.Unit;

public class QuickHitFrame extends JFrame {
    List<Unit> units;

    /**
     * Default constructor. Sets up a frame for an instance of QuickHit.
     */
    public QuickHitFrame() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        ImageIcon icon = new ImageIcon("src/main/resources/TidusLaugh.png");
        this.setIconImage(icon.getImage());
        initUnits();
        initChainPanel();
        initMacroPanel();
        
        new SavedSkillManager();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuickHit");
        this.pack();
        this.setVisible(true);
        new NewSkillDialog(1, 1);
    }

    /**
     * Initiates the unit panel.
     */
    private void initUnits() {
        JPanel unitsPanel = new JPanel();
        this.add(unitsPanel);
        for(int count = 0; count < Constants.MAX_NUMBER_OF_UNITS; count++) {
            units.add(new Unit(count));
            unitsPanel.add(new UnitPanel(units.get(count)));
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
