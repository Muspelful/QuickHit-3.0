package main.java;

public class ChainHit {
    int castSlot;
    int frame;
    boolean breaksChain;
    boolean tag;
    
    ChainHit(int slot, int frame, boolean tag) {
        this.castSlot = slot;
        this.frame = frame;
        breaksChain = false;
        this.tag = tag; 
    }

    /**
     * @return the breaksChain
     */
    public boolean breaksChain() {
        return breaksChain;
    }

    /**
     * @param breaksChain the breaksChain to set
     */
    public void setBreak(boolean breaksChain) {
        this.breaksChain = breaksChain;
    }

    /**
     * @return the castSlot
     */
    public int getCastSlot() {
        return castSlot;
    }

    /**
     * @return the frame
     */
    public int getFrame() {
        return frame;
    }

    /**
     * @return the tag
     */
    public boolean isTag() {
        return tag;
    }
}