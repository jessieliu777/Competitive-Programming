class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // Note since all rewards are positive make the 2nd mouse eat the remaining n-k cheeses so in total the mice eats all n cheeses to maximize reward. 
        // we want to calculate the 'gain' of reward if mouse1 eats a cheese over mouse2. So such gain for each cheese is reward1[i] - reward2[i]
        // so for every cheese i the 'gain' of mouse1 eating a cheese instead of mouse2 is:
        // reward1[0] - reward2[0], reward1[1] - reward2[1], ...
        // We want as much gain as possible for the k cheese mouse1 eats, so take k largest from the sequence
        // Now to get the actual reward1 value for the k largest gains we need to add back the reward2[i] that we deducted. 
        // => mouse1 rewards = sum(k largest (reward1[i]-reward2[i])) + sum(reward2[i] for reward2[i] that got deducted in the k largest sequence)
        // Mouse2 rewards is simply the other n-k cheese that mouse1 didn't eat
        // => mouse2 rewards = sum(reward2[i] for reward2[i] that didn't get deducted in the k largest sequences)

        // Now adding rewards together gives the maximal value for the mice:
        // total rewards = mouse1 rewards + mouse2 rewards
        // = sum(k largest (reward1[i]-reward2[i])) + sum(reward2[i] for reward2[i] that got deducted in the k largest sequence) + sum(reward2[i] for reward2[i] that didn't get deducted in the k largest sequences)
        // = sum(k largest (reward1[i]-reward2[i])) + sum(reward2)

        int res = 0, n = reward1.length, diff[] = new int[n];
        // diff[i] = reward1[i] - reward2[i], also add the reward2[i] to result while we are at it
        // so by the end we would've got sum(reward2)
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            res += reward2[i];
        }
        // now we need to get sum(k largest (reward1[i]-reward2[i]))
        // sort the diff arr from smallest to largest, now simply add the last n-k items
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) res += diff[n - 1 - i];
        return res;
    }
}