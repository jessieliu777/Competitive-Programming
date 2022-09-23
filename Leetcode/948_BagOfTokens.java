class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        // play left when enough power to minimize power loss
        // play right when not enough power to maximize power gained
        int left = 0;
        int right = tokens.length-1;
        int score = 0;
        boolean done = false;
        while (left <= right && !done){
            // if enough power, play left
            if (power >= tokens[left]){
                power -= tokens[left];
                score++;
                left++;
            } else {
                // if enough score, and we have more cards to play, play right
                if (score >= 1 && left != right){
                    power += tokens[right];
                    score--;
                    right--;
                } 
                // if not enough score, we can't do anything, so we are done
                else {
                    done = true;
                }
            }
        }
        return score;
    }
}