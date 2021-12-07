package main.java;

import main.java.ui.NewSkillDialog;
import main.java.ui.QuickHitFrame;

public class Main {

    /**
     * Launches the program.
     * @param args Arguments can alter program functionality
     */
    public static void main(String[] args) {
        new NewSkillDialog(1, 1);
        new QuickHitFrame();
    }
}