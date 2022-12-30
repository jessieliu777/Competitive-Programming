class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Sort cars by the start positions pos
        // Loop on each car from the end to the beginning
        // Calculate its time needed to arrive the target
        // cur records the current biggest time (the slowest)

        // If another car needs less or equal time than cur,
        // it can catch up this car fleet.

        // If another car needs more time,
        // it will be the new slowest car,
        // and becomes the new lead of a car fleet.
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; ++i)
            // map car position to the amount of time it takes to get to target 
            // since positions are unique they can represent their respective car
            m.put(position[i], (double)(target - position[i]) / speed[i]);
        int res = 0; double cur = 0;
        for (double time : m.values()) {
            // for cars that can reach target in less time than cur, then add it to the fleet, so in the code do nothing
            // for cars that take longer, create a new fleet
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }
}