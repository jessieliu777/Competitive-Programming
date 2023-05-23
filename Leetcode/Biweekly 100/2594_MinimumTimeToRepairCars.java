class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0, high = (long)1e14; // max rank * max cars *  max cars = 100 * 10^6 * 10^6
        // keep taking the median from min time and max time
        while (low < high) {
            long mid = low + (high - low) / 2, repaired_cars = 0;
            // for every mechanic try to repair the cars in mid mins
            // Note time = r * repaired_car^2 => repaired_cars = repaired_cars = sqrt(time/r), in this case time = mid
            for (int r: ranks) repaired_cars += Math.sqrt(mid / r);
            // if we couldn't repair all the cars then we need more time => move low to mid + 1
            if (repaired_cars < cars) low = mid + 1;
            // otherwise try to repair in optimal time => move high to mid
            else high = mid;
        }
        return low;
    }
}