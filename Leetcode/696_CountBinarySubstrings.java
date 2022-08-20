class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> groups = new ArrayList<>();
        int pre = -1;
        int count = 1;
        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - '0';
            if (pre != -1){
                if (cur == pre){
                    count++;
                } else {
                    groups.add(count);
                    count = 1;
                }
            } 
            pre = cur;
        }
        groups.add(count);
        int sum = 0;
        for (int j = 0; j<groups.size()-1; j++){
            sum += Math.min(groups.get(j), groups.get(j+1));
        }
        return sum;
    }
}