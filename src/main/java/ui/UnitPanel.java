package main.java.ui;

import javax.swing.JPanel;

import main.java.Unit;

public class UnitPanel extends JPanel {
    Unit unit;
    
    /**
     * Creates a unit in the specified slot.
     * @param slot The slot to place the unit.
     */
    public UnitPanel(Unit u) {
        unit = u;
    }
}