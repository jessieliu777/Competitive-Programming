class Solution {
    public String getHint(String secret, String guess) {
        // The idea is to iterate over the numbers in secret and in guess and count all bulls right away. 
        // For cows maintain an array that stores count of the number appearances in secret and in guess. 
        // Increment cows when either number from secret was already seen in guest or vice versa.
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10]; // numbers[i] the number of times i is seen in s but not g. negative denote number of times seen in g but not s
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            // if cur char matches for both then it s a bull
            if (s == g) bulls++;
            else {
                // cur char doesn't match and the s char is seen in g but not s before, so now it's found in s so that's a cow
                if (numbers[s] < 0) cows++;
                // cur char doesn't match and the g char is seen in s but not g before, so now it's found in g so that's a cow
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}