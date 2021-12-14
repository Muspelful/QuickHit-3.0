package main.java;

import java.util.ArrayList;
import java.util.Arrays;
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
     * Adds a skill of the specified family.
     * @param family The family of the skill being added
     */
    public void addSkill(Constants.Family family, int castSlot) {
        if(castSlot >= Constants.MAX_CAST_COUNT) {
            return;
        }
        if(castSlot < skills.size()) {
            skills.remove(castSlot);
        }
        List<Integer> hits;
        int offset;
        if(skills.size() == 0) {
            offset = Constants.FIRST_CAST_OFFSET;
        } else {
            offset = Constants.SUBSEQUENT_CAST_OFFSET;
        }
        switch(family) {
            case AMoE:
                hits = Arrays.asList(Constants.AT_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case AR:
                hits = Arrays.asList(Constants.AR_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case BS:
                hits = Arrays.asList(Constants.BS_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case CWA:
                hits = Arrays.asList(Constants.CWA_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case DR:
                hits = Arrays.asList(Constants.DR_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case Fld:
                hits = Arrays.asList(Constants.FLD_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case PB:
                hits = Arrays.asList(Constants.PB_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case SR:
                hits = Arrays.asList(Constants.SR_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
            case Tag:
                hits = Arrays.asList(Constants.TAG_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, true));
                break;
            case Tnd:
                hits = Arrays.asList(Constants.TORNADO_FRAMES);
                skills.add(castSlot, new Skill(hits, offset, 0, Constants.DEFAULT_CAST, castSlot, false));
                break;
        }
    }

    /**
     * Adds a custom skill with the specified properties.
     * @param hits The hit frames
     * @param offset The offset
     * @param cgDelay The cgDelay
     * @param castDelay The castDelay
     * @param tag Whether it's a tag skill
     * @param castSlot The skill slot it fits into
     */
    public void addSkill(List<Integer> hits, int offset, int cgDelay, int castDelay, boolean tag, int castSlot) {
        skills.add(new Skill(hits, offset, cgDelay, castDelay, castSlot, tag));
    }
    
    /**
     * Removes the skill in the specified cast slot.
     * If it's not the last slot, also removes all subsequent casts.
     * @param castSlot The slot to remove
     */
    public void removeSkill(int castSlot) {
        if(castSlot >= skills.size()) {
            return;
        }
        skills = skills.subList(0, castSlot);
    }

    class Skill {
        List<Integer> hits;
        int castFrame;
        int offset;
        int cgDelay;
        int castDelay;
        int castSlot;
        boolean tag;

        /**
         * Makes a new skill.
         * @param hits The hit frames
         * @param offset The offset
         * @param cgDelay The cg delay
         * @param castDelay The post cast delay
         * @param castSlot The cast slot
         * @param tag Whether it's a tag skill
         */
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