package main.java.ui;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Abstract version that will be used for NewSkillDialog and EditSkillDialog.
 */
public abstract class SkillDialog extends JDialog {
    protected int unitSlot, castSlot; 
    protected JTextField frameBox, castDelayBox, cgDelayBox, offsetBox;
    
    public SkillDialog(int unitSlot, int castSlot) {
        this.unitSlot = unitSlot;
        this.castSlot = castSlot;
        init();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Sets up the elements of the skill dialog.
     */
    private void init() {
        this.setTitle("Custom skill");
        ImageIcon icon = new ImageIcon("src/main/resources/TidusLaugh.png");
        this.setIconImage(icon.getImage());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.add(panel);
        
        JLabel frameLabel = new JLabel("Hit frames (e.g. 42-6-6-6-6-6-6-6-6)");
        frameBox = new JTextField();
        panel.add(frameLabel);
        panel.add(frameBox);
        
        JLabel castDelayLabel = new JLabel("Post cast delay");
        castDelayBox = new JTextField();
        panel.add(castDelayLabel);
        panel.add(castDelayBox);
        
        JLabel cgDelayLabel = new JLabel("CG delay (0 unless a CG LB)");
        cgDelayBox = new JTextField();
        panel.add(cgDelayLabel);
        panel.add(cgDelayBox);
        
        JLabel offsetLabel = new JLabel("Pre cast delay (almost always leave as default)");
        offsetBox = new JTextField();
        panel.add(offsetLabel);
        panel.add(offsetBox);
        
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setAlignmentX(LEFT_ALIGNMENT);
        JCheckBox tagBox = new JCheckBox("Tag skill");
        checkboxPanel.add(tagBox);

    
        JCheckBox saveBox = new JCheckBox("Save this skill to file");
        checkboxPanel.add(saveBox);
        panel.add(checkboxPanel);
    }
}