class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort by units
        int maxUnits = 0;
        int loaded = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        // for each box type:
        for (int[]boxtype: boxTypes){
            // num of boxes and number of units
            int num = boxtype[0];
            int units = boxtype[1];
            int put = 0;
            // keep adding but don't exceed total
            if (loaded + num > truckSize){
                put = truckSize-loaded;
            } else {
                put = num;
            }
            loaded = loaded + put;
            maxUnits = maxUnits + put*units;
        }
        return maxUnits;
            
    }
}