class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Key observation:
        // Suppose we have a decreasing sequence followed by a greater number
        // For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

        // We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
        // For example [9, 8, 7, 3, 2, 1, 6]
        // The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6

        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        // make the stack keep a decreasing subseq
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            // while there is items in the stack and the last number of the subseq is less than cur num, 
            // remove it from the stack and map it to cur num as cur num must be the next greater element
            while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
            stack.push(num);
        }
        // now go through all the nums in num1, and get its next greater element
        for (int i = 0; i < nums1.length; i++) nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}