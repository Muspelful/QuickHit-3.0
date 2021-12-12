package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.java.Constants;
import main.java.Unit;

public class ChainTest {

    /**
     * Tests a tag chain to ensure it doesn't break.
     */
    @Test
    public void tagTest() {
        Unit u = new Unit(0);
        List<Integer> hits = Arrays.asList(Constants.BS_FRAMES);
        u.addSkill(hits, 13, 0, 39, false);
        u.addSkill(hits, 14, 0, 39, false);
        u.getHits();
    }
}