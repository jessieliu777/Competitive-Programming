class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> elementFrequency = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.size(); right++) {
            int currentElement = nums.get(right);
            elementFrequency.put(currentElement, elementFrequency.getOrDefault(currentElement, 0) + 1);
            currentSum += currentElement;

            // Shrink the window if it exceeds k elements
            while (right - left + 1 > k) {
                int leftElement = nums.get(left);
                // Update frequency and sum
                elementFrequency.put(leftElement, elementFrequency.get(leftElement) - 1);
                // remove is needed since occurrence is used to count distinct elements
                if (elementFrequency.get(leftElement) == 0) elementFrequency.remove(leftElement);
                currentSum -= leftElement;
                // Move the left pointer to shrink the window
                left++;
            }

            // Check if the subarray has at least m distinct elements
            if (elementFrequency.size() >= m) maxSum = Math.max(maxSum, currentSum);
            
        }

        return maxSum;
    }
}