package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.java.Chain;
import main.java.ChainHit;
import main.java.Constants;
import main.java.Unit;

public class ChainTest {

    /**
     * Tests a tag chain to ensure it doesn't break.
     */
    @Test
    public void tagTest() {
        Unit u = new Unit(0);
        u.addSkill(Constants.Family.Tag, 0);
        List<Unit> unitList = new ArrayList<Unit>();
        unitList.add(u);
        Chain c = new Chain();
        List<ChainHit> hits = c.getHits(unitList);
        
        for(ChainHit thisHit : hits) {
            assertFalse(thisHit.breaksChain());
        }
        
        u.getHits();
    }
    
    /**
     * Tests a unit solo casting to ensure that there's a break.
     */
    @Test
    public void soloBreakTest() {
        Unit u = new Unit(0);
        u.addSkill(Constants.Family.BS, 0);
        List<Unit> unitList = new ArrayList<Unit>();
        unitList.add(u);
        Chain c = new Chain();
        List<ChainHit> hits = c.getHits(unitList);
        
        assertFalse(hits.get(0).breaksChain());
        for(int count = 1; count < hits.size(); count++) {
            assertTrue(hits.get(count).breaksChain());
        }
    }
    
    /**
     * Tests two units with a gap of exactly 20 frames between hits, to ensure it does not break.
     */
    @Test
    public void twentyFrames() {
        Unit one = new Unit(0);
        List<Integer> firstHit = new ArrayList<Integer>();
        firstHit.add(0);
        one.addSkill(firstHit, 13, 0, 39, false, 0);
        Unit two = new Unit(1);
        List<Integer> secondHit = new ArrayList<Integer>();
        secondHit.add(20);
        two.addSkill(secondHit, 13, 0, 39, false, 0);
        
        List<Unit> unitList = new ArrayList<Unit>();
        unitList.add(one);
        unitList.add(two);
        
        Chain c = new Chain();
        List<ChainHit> hits = c.getHits(unitList);
        
        assertFalse(hits.get(1).breaksChain());
    }
    
    /**
     * Tests two units with a gap of exactly 21 frames between hits, to ensure it breaks.
     */
    @Test
    public void twentyOneFrames() {
        Unit one = new Unit(0);
        List<Integer> firstHit = new ArrayList<Integer>();
        firstHit.add(0);
        one.addSkill(firstHit, 13, 0, 39, false, 0);
        Unit two = new Unit(1);
        List<Integer> secondHit = new ArrayList<Integer>();
        secondHit.add(21);
        two.addSkill(secondHit, 13, 0, 39, false, 0);
        
        List<Unit> unitList = new ArrayList<Unit>();
        unitList.add(one);
        unitList.add(two);
        
        Chain c = new Chain();
        List<ChainHit> hits = c.getHits(unitList);
        
        assertTrue(hits.get(1).breaksChain());
    }
    
    /**
     * Tests one unit with a gap of exactly 21 frames between tag hits, to ensure it breaks.
     */
    @Test
    public void twentyOneFrameTag() {
        Unit u = new Unit(0);
        List<Integer> firstHit = new ArrayList<Integer>();
        firstHit.add(0);
        firstHit.add(21);
        u.addSkill(firstHit, 13, 0, 39, true, 0);
        
        List<Unit> unitList = new ArrayList<Unit>();
        unitList.add(u);
        
        Chain c = new Chain();
        List<ChainHit> hits = c.getHits(unitList);
        
        assertTrue(hits.get(1).breaksChain());
    }
}