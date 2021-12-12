package main.java;

public class ChainHit implements Comparable<ChainHit> {
    int unitSlot;
    int frame;
    boolean breaksChain;
    boolean tag;
    
    ChainHit(int slot, int frame, boolean tag) {
        this.unitSlot = slot;
        this.frame = frame;
        breaksChain = false;
        this.tag = tag; 
    }

    /**
     * Whether or not this hit breaks the chain.
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
    public int getUnitSlot() {
        return unitSlot;
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

    /**
     * Allows for sorting by frame.
     * @param c The ChainHit being compared to.
     * @return Typical compareTo behavior based on frame
     */
    @Override
    public int compareTo(ChainHit c) {
        return ((Integer) frame).compareTo(c.frame);
    }
    
    /**
     * Returns the frame of the hit. Useful for debugging.
     * @return The frame of the hit
     */
    public String toString() {
        return Integer.toString(frame);
    }
}