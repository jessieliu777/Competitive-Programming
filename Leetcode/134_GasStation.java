class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,avail=0,ind=0;
        for(int i=0;i<gas.length;i++){
            // the total is always the same no matter where we start since one cycle always covers every station
            total+=gas[i]-cost[i];
            avail+=gas[i]-cost[i];
            // move the start index to the next gas station if at any point gas isn't enough to cover cost
            if(avail<0){
                avail=0;
                ind=i+1;
            }
        }
        return total < 0 ? -1 : ind;
    }
}