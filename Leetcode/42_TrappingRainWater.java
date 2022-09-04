class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        // use 2 pointers, start from the 'edges'
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (leftIndex < rightIndex){
            if (height[leftIndex] < leftMax){
                result += (leftMax-height[leftIndex]);
            } else {
                leftMax = height[leftIndex];
            }
            if (height[rightIndex] < rightMax){
                result += (rightMax-height[rightIndex]);
            } else {
                rightMax = height[rightIndex];
            }
            if (height[leftIndex] >= height[rightIndex]){
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return result;
    }
}