class Solution {
    Set<Integer> set;
    private boolean helper(int n) {
        while (n > 0) {
            int cur = n % 10;
            if (cur == 0 || set.contains(cur)) return false;
            set.add(cur);
            n /= 10;
        }
        return true;
    }
    public boolean isFascinating(int n) {
        set = new HashSet<>();
        int n2 = n * 2;
        int n3 = n * 3;

        return helper(n) && helper(n2) && helper(n3) && set.size() == 9;
    }
}