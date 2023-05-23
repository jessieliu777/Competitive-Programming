class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // Recognize that if there is an even amount of negative numbers, you can eliminate all the negatives signs in the following fashion:

        // If there is a pair of adjacent negative numbers, just remove both negative signs
        // If the remaining negative numbers are separated from each other, just swap their negative signs with the adjacent positive number until they are adjacent to each other, and then you can remove 2 negative signs at a time
        // If there is an odd amount of negative sign, there will be a negative sign in the end, and we can move that negative sign to the smallest number in the matrix (by swapping as above)

        // So, if the number of negative signs is even, the answer is the sum of the absolute value of all elements. If it is odd, we will have to minus 2 times the number with smallest absolute value (for we have to change + sign to -) to get the answer:
        int countNegative = 0;
        long absoluteSum = 0;
        int minimumPositiveValue = Integer.MAX_VALUE;
        for(int[] row : matrix){
            for(int element : row){
                if(element < 0) countNegative++;
                absoluteSum += Math.abs(element);
                minimumPositiveValue = Math.min(Math.abs(element), minimumPositiveValue);
            }
        }
        if(countNegative % 2 == 0) return absoluteSum;
        else return absoluteSum - 2 * minimumPositiveValue;
    }
}