package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chain {
    
    /**
     * Calculates the chainhits for a given turn, marking any hits that break the chain.
     * @param units The units that are chaining
     * @return The hits for that turn
     */
    public List<ChainHit> getHits(List<Unit> units) {
        List<ChainHit> hits = new ArrayList<ChainHit>();
        for(Unit thisUnit : units) {
            hits.addAll(thisUnit.getHits());
        }
        Collections.sort(hits);
        
        if(hits.size() > 1) {
            ChainHit prevHit = hits.get(0);
            for(int count = 1; count < hits.size(); count++) {
                //Chains break if there is more than 20 frames between hits,
                //or if the same unit hits twice in a row with non-tag skills.
                if(hits.get(count).getFrame() - prevHit.getFrame() > 20) {
                    hits.get(count).breaksChain = true;
                } else if(hits.get(count).getUnitSlot() == prevHit.getUnitSlot()
                        && !hits.get(count).isTag() && !prevHit.isTag()) {
                    hits.get(count).breaksChain = true;
                }
                prevHit = hits.get(count);
            }
        }
        
        return hits;
    }
}