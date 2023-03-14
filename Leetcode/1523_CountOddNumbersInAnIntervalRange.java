class Solution {
    public int countOdds(int low, int high) {
        // let count1 = the count of odd numbers between 1 and low - 1 = low / 2
        // let count2 = the count of odd numbers between 1 and high = (high + 1 ) / 2
        // so num of odd numbers from low to high is count2 - count1
        return (high+1)/2 - low/2;
    }
}