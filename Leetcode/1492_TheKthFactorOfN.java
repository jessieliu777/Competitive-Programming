class Solution {
    public int kthFactor(int n, int k) {
        // for all nums < sqrt(n), if it divides n and it s the kth factor then return it
        for(int i = 1; i < Math.sqrt(n); ++i) if(n % i== 0 && --k == 0) return i;
        // if i | n then (n/i) | n, so for all potential factors > sqrt(n), can get it by getting the factors i < sqrt(n), then do n/i.
        // For all such factors, if it's the kth one then return it                       
        for(int i = (int) Math.sqrt(n); i >= 1; --i) if(n % (n/i) == 0 && --k == 0) return n/i;          
        return -1;
    }
}