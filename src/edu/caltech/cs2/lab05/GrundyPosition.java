package edu.caltech.cs2.lab05;

import java.util.*;

public class GrundyPosition {
    /*
     * Stores a mapping from the height of a pile to how many of those piles exist.
     * Does not include piles of size less than three.
     */
    private SortedMap<Integer, Integer> heapCounts;
    //private String s;
    //  public ArrayList<Integer> heap;
    /**
     * Initializes a GrundyPosition with a single heap of height heapHeight.
     **/
    public GrundyPosition(int heapHeight) {
        //this.heap = new ArrayList<>();
        this.heapCounts = new TreeMap<>();
        if(heapHeight >= 3) {
            this.heapCounts.put(heapHeight, 1);
        }
        // return heapCounts + "=" + heapCounts;

    }

    /**
     * Returns a list of legal GrundyPositions that a single move of Grundy's Game
     * can get to.
     **/
    public List<GrundyPosition> getMoves() {
        int pos = heapCounts.firstKey();
        List<GrundyPosition> moves = new ArrayList<GrundyPosition>();
        int n = heapCounts.size();
        for (int key : heapCounts.keySet()) {
            int value = heapCounts.get(key);
            //{4,3}
            for (int j = 1; j < key/2 + 1; j++) {
                TreeMap<Integer, Integer> secondary = new TreeMap<>(heapCounts);
                if (value - 1 != 0) {
                    secondary.put(key, value - 1);
                }
                else{
                    secondary.remove(key);
                }
                //
                // (4, 2)    (2,2)

                if (j >= 3) {
                    secondary.put(j, secondary.getOrDefault(j, 0) + 1);
                }
                if ((key - j) >= 3) {
                    secondary.put(key - j, secondary.getOrDefault(key - j, 0) + 1);
                }
                if(j != key-j){
                    GrundyPosition a = new GrundyPosition(0);
                    a.heapCounts = secondary;
                    moves.add(a);
                }


                //  {4: 3}
            }

        } return moves;
    }
    //{4: 3}
    //
    //{4: 1} {1: 1} {3: 1}
    //remove entry

    //for heaps in heap count.keySet
    // for each heap:
//        for(Map.Entry<String, String> entry : map.entrySet()
//                heapCounts.entrySet(): )
//
//       HashMap<Integer,Integer> pairs = new HashMap<>();
//   //9
//        // 8 1
//        // 7 2
//
//
//
//
//            int smallPile = pos/(pos-1);
//            int BigPile = pos - smallPile;
//            heapCounts.put(BigPile, 1);
//        while(Math.round(smallPile) <= 2){
//            smallPile = smallPile + 1;
//            BigPile = pos - smallPile;
//            heapCounts.put(BigPile, 1);
//





    //        List<GrundyPosition> moves = new ArrayList<>();
//        for (int height : heapCounts.keySet()) {
//            if (height > 1) {
//                for (int split = 1; split < height; split++) {
//                    //1
//                    int leftHeight = split;
//                    //5-1 = 4
//                    int rightHeight = height - split;
//                    GrundyPosition move = new GrundyPosition(leftHeight);
//                    move.addHeap(rightHeight);
//                    moves.add(move);
//                }
//            }
//        }
//        return moves;
//    }


//
//                private List<GrundyPosition> getMovesHelper(int height, List<Integer> positions) {
//                    if(height != 1 && height != 0 && height != 2) {
//
//                        int smallerHeap = (height -2)/2;
//                        int biggerHeap = (height+1)/2;
//                        positions.add(smallerHeap);
//                        positions.add(biggerHeap);
//                        getMovesHelper(height,positions);

    //create two smaller heaps
    // 8
    // math.floor() rounds down
    // smallerHeap = (height-2)/2 (parent node?) 3
    //biggerHeap  = (height+1)/2 (


    public boolean isTerminalPosition() {

        if(heapCounts.isEmpty()){
            return true;
        }

//        List<GrundyPosition> moves = new ArrayList<GrundyPosition>();
//        for(Integer key: heapCounts.keySet()){
//            moves.add(new GrundyPosition(key));
//        }
        //return moves;
        //find sprague-grundy value

        return false;
    }
//    public int computeNimValue(ArrayList<Integer> heapz){


    public boolean isPPosition() {
        if(table.containsKey(this)){
            return table.get(this);
        }
        if(this.isTerminalPosition()){
            return true;
        }

        else {

            List<GrundyPosition> positions = getMoves();
            for (GrundyPosition position : positions) {

                    if (!position.isNPosition()) {
                        table.put(this, false);
                        return false;
                    }
//                        Meme1(position) == true){
//                    return false;
                }
            }

//

        table.put(this, true);
        return true;
    }
    private static HashMap<GrundyPosition, Boolean> table = new HashMap<>();

    public Boolean Meme(GrundyPosition gp){
        if(!this.table.containsKey(gp)){
            table.put(gp, gp.isPPosition());
        }

        return table.get(gp);
    }
    public Boolean Meme1(GrundyPosition gp){
        if(!this.table.containsKey(gp)){
            table.put(gp, !gp.isNPosition());
        }

        return table.get(gp);
    }







    public boolean isNPosition()  {
        if(table.containsKey(this)){
            return !(table.get(this));
        }
        if(this.isTerminalPosition()){
            return false;
        }
        else{
            List<GrundyPosition> positions = getMoves();
            //
            for(GrundyPosition position: positions){
                //store position
               // if(Meme(position) == true){
                if(position.isPPosition()){
                    table.put(this,false);
                    return true;
                }
            }
        }
        table.put(this, true);
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