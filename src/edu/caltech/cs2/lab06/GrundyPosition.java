package edu.caltech.cs2.lab06;

import java.util.List;
import java.util.SortedMap;

public class GrundyPosition {
    /*
     * Stores a mapping from the height of a pile to how many of those piles exist.
     * Does not include piles of size less than three.
     */
    private SortedMap<Integer, Integer> heapCounts;

    /**
     * Initializes a GrundyPosition with a single heap of height heapHeight.
     **/
    public GrundyPosition(int heapHeight) {
    }

    /**
     * Returns a list of legal GrundyPositions that a single move of Grundy's Game
     * can get to.
     **/
    public List<GrundyPosition> getMoves() {
        return null;
    }

    public boolean isTerminalPosition() {
        return false;
    }

    public boolean isPPosition() {
        return false;
    }

    public boolean isNPosition()  {
        return false;
    }

    /**
     * Ignore everything below this point.
     **/

    @Override
    public int hashCode() {
       return this.heapCounts.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GrundyPosition)) {
            return false;
        }
        return this.heapCounts.equals(((GrundyPosition) o).heapCounts);
    }

    @Override
    public String toString() {
        return this.heapCounts.toString();
    }
}