class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0, hi = 100_000_000_000_000L;
        // for all possible total time taken from 0 to 10^7, do bin search
        while (lo < hi) {
            // try the time in the middle
            long mid = lo + (hi - lo) / 2;
            long trips = 0;
            // go through all the buses, the amount of trips is the total time/time per bus
            // since each bus takes trip independently and successively we can just add the trip count using the above formula for every bus
            for (int t : time) trips += mid / t;
            // if the total trip count is less than given we need to continue with more trips. Clearly more time needs to be taken so move low to mid+1
            if (trips < totalTrips) lo = mid + 1;
            // otherwise if the trip count is enough then see if we can minimize, so do hi = mid
            else hi = mid;
        }
        // Eventually we will reach lo = high for minimal
        return lo;
    }
}