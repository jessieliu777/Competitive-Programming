class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        // left = nonincrease will store the consecutive non-increase count until current index
        // right = nondecrease will store the consecutive non-decrease count until curernt index
        int[] left = new int[n], right = new int[n];
        List<Integer> res = new ArrayList<>();

        
        for(int i = 1; i < n; i++) {
            // to calculate nonincrease = decreasing from left to right
            left[i] = security[i] <= security[i - 1] ? left[i - 1] + 1 : 0;
            int j = n-1-i;
            // to calculate nondecrease = increasing from left to right
            right[j] = security[j] <= security[j + 1] ? right[j + 1] + 1 : 0;
        }
        
        // Then we find index whose nonincrease count and nondecrease count are both larger than time.
        for(int i = time; i < n - time; i++) if(left[i] >= time && right[i] >= time) res.add(i);
       
        return res;
    }
}