class Solution {
    public int[] shuffle(int[] nums, int n) {
        // BASIC IDEA:
        // Store the pair of numbers and then
        // Retreive each number, from that pair where they were stored, one by one and place them at their desired positions.
        // In order to avoid overwriting values, store the "pair of numbers" in the right half of the array and retrieve the numbers by one according to the requirement.

        // Suppose we have 2 numbers num1 = 4 and num2 = 9 and maxValue = 10
        // Formula:
        // to store -> pair = (num2 × maxValue) + num1
        // to retrieve -> pair % maxValue and pair / maxValue

        // Storing the pair of numbers
        // (9 × 10) + 4 = 94 --> from above formula (num2 × maxValue) + num1
        // 94 is stored
        // Retrieving each number one by one
        // 94 % 10 = 4
        // we got first number as 4
        // 94 / 10 = 9
        // we got second number as 9

        // Same idea goes for large cases and array as well but instead of 10, we will take 1024 to store pairs and retrieve each number
        // NOTE: Here, we will take 1024 because of the given constraints 1 <= nums[i] <= 10^3 i.e. the largest number in the array will be 1000

        // Binary representation of 1000 is 1111101000, consisting of total 10 bits
        // Binary representation of 1024 is 10000000000, consisting of total 11 bits
        // and if we multiply 1000 with 1024 i.e. (1000 * 1024), we will get 1024000
        // Binary representation of 1024000 is 11111010000000000000, consisting of total 20 bits which is less than the number of bits (32bits) of int data type, so we can store the number pairs(by multiplying one number with 1024 and adding another number to it) to retrieve each indivisual number later on(by taking out the remainder and the quotient).
        // eg: suppose we have an array of length 4 and n is 2
        // nums = [5, 2, 1000, 3] and n = 2

        int len = nums.length;
        
        // store the pair of numbers x_i, y_i) in right half of the original array
        // to store the pair of numbers in right half of the original array
        // for(int i = n; i < len; i++)
        // nums[i] = (nums[i] * 1024) + nums[i - n];
        // Iteration 1:
        // when i = 2, (i = 2 because value of n is 2)
        // nums[2] = (1000 × 1024) + 5
        // so, nums[2] = 1024005

        // Iteration 2:
        // when i = 3,
        // nums[3] = (3 × 1024) + 2
        // so, nums[3] = 3074

        // Now, the original array
        // [5, 2, 1000, 3]
        // 0  1     2     3   <-- Indexes
        // becomes
        // [5, 2, 1024005, 3074]
        // 0  1        2          3   <-- Indexes
        for(int i = n; i < len; i++) nums[i] = (nums[i] << 10) | nums[i - n];
        // LEQV for(...) nums[i] = (nums[i] * 1024) + nums[i - n];
        // nums[i] * 1024 = nums[i] * 2^10 = nums[i] << 10
        // since nums[i-n] < nums[i] so (nums[i] << 10) | nums[i - n] LEQV (nums[i] << 10) + nums[i - n]
        
        int index = 0;
        // to retrive values from the pair of numbers and placing those retrieved value at their desired position
        // Iteration 1:
        // when index = 0 and i = 2, (i = 2 because value of n is 2)
        // nums[0] = 1024005 % 1024 = 5
        // nums[1] = 1024005 / 1024 = 1000
        // now, index = 2 (from index += 2)

        // Iteration 2:
        // when index = 2, i = 3,
        // nums[2] = 3074 % 1024 = 2
        // nums[3] = 3074 / 1024 = 3

        // Iteration will be stopped now as the condition become false and we got the array as following
        // [5, 1000, 2, 3] <-- Desired Output
        // 0     1     2  3  <-- Indexes
        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] & 1023; // LEQV nums[i] % 1024; (1023 has all 9 bits where each bit is on. nums[i] & 1023 iff nums[i] is on for bits before 10th bit, which is the def of nums[i] % 1024)
            nums[index + 1] = nums[i] >>> 10; // LEQV nums[i] / 1024; Also, >>> is logical left shift (fill empty LHS with 0)
        }
        
        return nums;
    }
}