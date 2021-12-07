package main.java.ui;

import main.java.Constants;

public class NewSkillDialog extends SkillDialog {

    public NewSkillDialog(int unitSlot, int castSlot) {
        super(unitSlot, castSlot);
        cgDelayBox.setText("0");
        castDelayBox.setText(Integer.toString(Constants.DEFAULT_DELAY));
        if(castSlot == 1) { 
            offsetBox.setText(Integer.toString(Constants.FIRST_CAST_OFFSET));
        } else {
            offsetBox.setText(Integer.toString(Constants.SUBSEQUENT_CAST_OFFSET));
        }
    }

}
