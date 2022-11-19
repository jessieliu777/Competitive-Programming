class Solution {
    public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int len = s.length();
        int ans = len;
        // for all chars
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }
        return ans == len? -1 : ans;
    }
}