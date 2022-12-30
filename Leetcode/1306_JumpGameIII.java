class Solution {
    public boolean canReach(int[] arr, int start) {
        // Check 0 <= start < A.length since we don't want to go out of bounds'
        return 0 <= start && start < arr.length 
        // In the line after this flip the checked number to negative arr[start] = -arr[start] to denote that we akready took arr[start] steps. So in this line if we took it then arr[start] would've been set negative by some prev iteration and we don't want to take it again
        && arr[start] >= 0 
        // If arr[start] == 0, get it and return true
        && ((arr[start] = -arr[start]) == 0 
            // Continue to check canReach(arr, start + arr[start]) and canReach(arr, start - arr[start])
            || canReach(arr, start + arr[start]) 
            || canReach(arr, start - arr[start]));
    }
}