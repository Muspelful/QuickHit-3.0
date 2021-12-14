package main.java;
/*
 * Just various constants in case I ever need to change them.
 * 
 * If the max number of units ever goes up (which is highly unlikely),
 * in addition to changing the constant here,
 * the macro generator would need to be rewritten for the new positions of unit buttons for various slots.
 * The chain visualizer would also need to be made vertically larger to accomodate more units.
 * 
 * The window would need to be made wider to so that the additional units aren't off the screen.
 * (Considering the width of most monitors, this would probably require a complete redesign of the UI.)
 */
public class Constants {
    public enum Family { AMoE, AR, BS, CWA, DR, Fld, PB, SR, Tag, Tnd }; 
    public static final int MAX_CAST_COUNT = 5;
    public static final int MAX_NUMBER_OF_UNITS = 6;
    public static final String[] CHAIN_FAMILY_NAMES = {"None", "Copy previous skill", "Custom skill", "Absolute Mirror of Equity",
            "Aureole Ray", "Bolting Strike", "Chaos Wave Awakened",
            "Divine Ruination", "Flood", "Protector's Bayonet", "Stardust Ray", "Tag (family)", "Tornado"};
    public static final String[] FIRST_CAST_CHAIN_FAMILY_NAMES = {"None", "Custom skill", "Absolute Mirror of Equity",
            "Aureole Ray", "Bolting Strike", "Chaos Wave Awakened",
            "Divine Ruination", "Flood", "Protector's Bayonet", "Stardust Ray", "Tag (family)", "Tornado"};
    public static final Integer[] AR_FRAMES = {42, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
    public static final Integer[] AT_FRAMES = {70, 6, 6, 6, 6, 6, 6, 6};
    public static final Integer[] BS_FRAMES = {42, 6, 6, 6, 6, 6, 6, 6, 6};
    public static final Integer[] CWA_FRAMES = {42, 20, 20, 20, 20, 20, 20, 20};
    public static final Integer[] DR_FRAMES = { 70, 7, 5, 7, 7, 7, 7};
    public static final Integer[] FLD_FRAMES = {133, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    public static final Integer[] PB_FRAMES = {30, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
    public static final Integer[] SR_FRAMES = {110, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    public static final Integer[] TAG_FRAMES = {12, 9, 9, 9, 9, 9, 9};
    public static final Integer[] TORNADO_FRAMES = {80, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    public static final int DEFAULT_CAST = 39;
    public static final int FIRST_CAST_OFFSET = 13;
    public static final int SUBSEQUENT_CAST_OFFSET = 14;
    public static final double MEMU_FRAME_LENGTH = 16666.66666;
    public static final int MEMU_MACRO_START = 1000;
    public static final int MEMU_CLICK_RELEASE_DELAY = 100;
    public static final int[] MEMU_UNIT_X_COORDS = {166, 166, 166, 504, 504, 504};
    public static final int[] MEMU_UNIT_Y_COORDS = {832, 960, 1088, 832, 960, 1088};
    public static final String MEMU_CLICK_RELEASE_TAIL = "--VINPUT--MULTI2:1:0:-1:-1:-2:2\n";
    public static final String MEMU_CLICK_DOWN_HEADER = "--VINPUT--MULTI2:1:0:0:";
    public static final String MEMU_CLICK_DOWN_TAIL = ":0\n";
}