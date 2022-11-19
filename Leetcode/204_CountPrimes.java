class Solution {
    public int countPrimes(int n) {
        // let prime[i] = i is prime
        // initialize everything to true
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }
        
        // if i is prime then all multiples of i are not, so set to the multiples to be false
        // no need to check non-prime since the base case already set the non-prime's multiples to false
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == true) { 
                for (int j = i * i; j < n; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        
        // now just count the prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == true)
                count++;
        }
        return count;
    }
}