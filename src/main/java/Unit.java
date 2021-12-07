package main.java;

import java.util.ArrayList;
import java.util.List;

public class Unit extends Constants {
    private Skill[] skills;
    private String name;
    private int sendTime;
    
    /**
     * Creates a unit in the specified slot.
     * @param slot The unit's slot.
     */
    public Unit(int slot) {
        name = "Unit " + slot;
        skills = new Skill[MAX_CAST_COUNT];
        sendTime = 0;
        for(int count = 0; count < MAX_CAST_COUNT; count++) {
            skills[count] = null;
        }
    }

    /**
     * Calculates and returns this unit's chainhits.
     * @return The chainhits for this unit
     */
    public List<ChainHit> getHits() {
        ArrayList<ChainHit> hits = new ArrayList<ChainHit>();
        for(int count = 0; count < MAX_CAST_COUNT; count++) {
            if(skills[count] == null) {
                return hits;
            } else {
                //TODO: Get the hits.
            }
        }
        return hits;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sendTime
     */
    public int getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime the sendTime to set
     */
    public void setSendTime(int sendTime) {
        this.sendTime = sendTime;
    }

    
}