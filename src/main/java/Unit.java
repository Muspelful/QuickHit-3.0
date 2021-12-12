package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Unit {
    private List<Skill> skills;
    private int sendTime;
    private int slot;

    /**
     * Creates a unit in the specified slot.
     * @param slot The unit's slot.
     */
    public Unit(int slot) {
        this.slot = slot;
        skills = new ArrayList<Skill>(Constants.MAX_CAST_COUNT);
        sendTime = 0;
    }

    /**
     * Calculates and returns this unit's chainhits.
     * @return The chainhits for this unit
     */
    public List<ChainHit> getHits() {
        ArrayList<ChainHit> hits = new ArrayList<ChainHit>();
        int currentCastFrame = sendTime;
        for(int count = 0; count < skills.size(); count++) {
            currentCastFrame += skills.get(count).offset + skills.get(count).cgDelay;
            int currentHitFrame = currentCastFrame;
            for(int thisHit : skills.get(count).hits) {
                currentHitFrame += thisHit;
                hits.add(new ChainHit(slot, currentHitFrame, skills.get(count).tag));
            }
            currentCastFrame += skills.get(count).castDelay;
        }
        Collections.sort(hits);
        for(ChainHit thisHit : hits) {
            System.out.println(thisHit);
        }
        return hits;
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

    /**
     * 
     * @param family The family of the skill being added.
     */
    public void addSkill(Constants.Family family) {
        //TODO: Implement
    }

    public void addSkill(List<Integer> hits, int offset, int cgDelay, int castDelay, boolean tag) {
        //TODO: Implement
        skills.add(new Skill(hits, offset, cgDelay, castDelay, skills.size(), tag));
    }

    class Skill {
        List<Integer> hits;
        int castFrame;
        int offset;
        int cgDelay;
        int castDelay;
        int castSlot;
        boolean tag;

        public Skill(List<Integer> hits, int offset, int cgDelay,
                int castDelay, int castSlot, boolean tag) {
            this.hits = hits;
            this.offset = offset;
            this.cgDelay = cgDelay;
            this.castDelay = castDelay;
            this.castSlot = castSlot;
            this.tag = tag;
        }


    }
}