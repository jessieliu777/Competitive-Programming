class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = (l + r) / 2, total = 0;
            // total += (p+m-1) / m equal to total += Math.ceil(p/m)
            // also total number of hours on pile p = number of bananas in pile / speed
            for (int p : piles) total += (p + mid - 1) / mid;
            if (total > h) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}