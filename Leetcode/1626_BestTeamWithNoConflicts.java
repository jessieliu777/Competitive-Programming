class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] team = new int[len][2];
        // team is [age, score]
        for (int i = 0; i < len; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i]; 
        }
		// sort first by age then by score
        Arrays.sort(team, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        // dp[i] = the max sum for all LIS ending in i (inclusive) and must include i
        // initially score of 0th player is team[0][1] and cur LIS is just a list of 1 score
        int[] dp = new int[len];
        dp[0] = team[0][1];
        int result = dp[0];
        for (int i = 1; i < len; i++) {
            // add the ith score to our cur LIS sum. By def of dp the score of ith player must be included
            dp[i] = team[i][1]; 
			// go through all the seq from 0 to i
            for (int j = 0; j < i; j++) {
                // given younger player must have less score than older then since we already sorted from young 
                // to old then for all j < i , j must have at most score than i to be considered added to the team
                if (team[j][1] <= team[i][1]) dp[i] = Math.max(dp[i], dp[j] + team[i][1]);
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}