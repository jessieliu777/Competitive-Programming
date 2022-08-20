class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int time = 1;
        Boolean crash = false;
        while (! crash){
            if (memory2 > memory1){
                if (memory2 >= time){
                    memory2 -= time;
                } else {
                    crash = true;
                }
            } else {
                if (memory1 >= time){
                    memory1 -=time;
                } else {
                    crash = true;
                }
            }
            
            time++;
        }
        return new int[] {time-1, memory1, memory2};
    }
}