class Solution {
    double[][] memo = new double[200][200]; // memo[i][j] = prob of i servings emptied first + 0.5 * prob of i servings, j servings emmptied at the same time. As explained below, n > 4800 can be hard coded to return 1, so max n to calc is 4800. (4800ml+24)/25 = 192.96 < 200 'servings' so 200 is sufficient bound for a, b servings

    public double helper(int a, int b) {
        // if a, b actually reached 0 at the same time, then the probability that a is emptied first is 0%< prob of a, b at the same time = 100%, half of that is 50% = 0.5
        if (a <= 0 && b <= 0) return 0.5;
        // if a actually reached 0 first, prob of A becoming 0 first = 100%, prob of a, b at the same time = 0%, so total is 1 = (100%) + 0 = 1
        if (a <= 0) return 1;
        // if b actually reached 0 first, prob of a becoming 0 first is 0, probability of a, b both reaching 0 is 0
        if (b <= 0) return 0;
        if (memo[a][b] > 0) return memo[a][b];
        // the probability of each of the 4 ops is chosen equally, so total prob is the result prob of each op * 0.25
        memo[a][b] = 0.25 * (helper(a - 4, b) + helper(a - 3, b - 1) + helper(a - 2, b - 2) + helper(a - 1, b - 3));
        return memo[a][b];
    }

    public double soupServings(int n) {
        // 1. consider only how many servings left in A and B.
        // 1 serving = 25ml.
        // less than 25ml is still considered as one serving.

        // 2. use dp w/ memoization
        // f(a,b) means the result probability for a servings of soup A and b servings of soup B.
        // f(a-4,b) means that we take the first operation: Serve 100 ml (4 servings) of soup A and 0 ml of soup B. f(a-3,b-1), f(a-2,b-2), f(a-1,b-3) are other 3 operations.
        // The condition a <= 0 and b <= 0 means that we run out of soup A and B at the same time, so we should return a probability of 0.5, which is half of 1.0.

        // 3. Hard code large input n
        // Note that we do not have the operation where all 100 ml's of soup B are used first. "
        // It's obvious that A is easier to be empty than B. And when N gets bigger, we have less chance to run out of B first.
        // So as N increases, our result increases and it gets closer to 100 percent = 1.

        // Answers within 10^-5 of the true value will be accepted as correct.
        // Now it's obvious that when N is big enough, result is close enough to 1 and we just need to return 1.
        // When I incresed the value of N:
        // When N = 4800, the result = 0.999994994426
        // When N = 4801, the result = 0.999995382315
        // So if N>= 4800, just return 1 and it will be enough.
        
        // do (n+24)/25 to divide into 'servings'
        return n > 4800 ?  1.0 : helper((n + 24) / 25, (n + 24) / 25);
    }
}