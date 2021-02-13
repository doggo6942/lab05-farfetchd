package edu.caltech.cs2.lab07;

import java.util.List;
import java.util.SortedMap;

public class GrundyPosition {
    private SortedMap<Integer, Integer> heapCounts;

    public GrundyPosition(int heapHeight) {
    }

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