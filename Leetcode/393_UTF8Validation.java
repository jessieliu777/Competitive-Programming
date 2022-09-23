class Solution {
    public boolean validUtf8(int[] data) {
        int mask1 = 1 << 7; // shift left by 7 bits --> 10000000
        int mask2 = 1 << 6; // shift left by 6 bits --> 01000000
        int bytesToProcess = 0;
        for (int num: data){
            // initialize bytes to process
            if (bytesToProcess == 0){
                int mask = 1 << 7;
                while ((mask & num) != 0){
                    bytesToProcess++;
                    mask = mask >> 1;
                }
                // if bytesToProcess is not updated, then there are none
                if (bytesToProcess == 0){
                    continue;
                }
                // by problem, we cannot have more than 4 bytes
                if (bytesToProcess > 4 || bytesToProcess == 1){
                    return false;
                }
            } else {
                // if first 2 bits are not '10'
                if (!((num & mask1) != 0 && (num & mask2) == 0)){
                    return false;
                }
            }
            bytesToProcess--;
        }
        return bytesToProcess == 0;
    }
}