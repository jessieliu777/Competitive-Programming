class Solution {
    public boolean isHappy(int n) {
        // Create a hash set...
        Set<Integer> hset = new HashSet<Integer>();
        while (hset.add(n)) {
            int total = 0;
            while (n > 0) {
                total += (n % 10) * (n % 10);
                n /= 10;
            }
            if (total == 1)return true;
            else
                n = total;
        }
        // If current number is already in the HashSet, that means we're in a cycle so false
        return false;
    }
}