class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        // left = max(weights) = min capacity, since we need the capacity to be above all weights, right = sum(weights) = max capacity is the total sum of all weights
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        // while min capacity < max capacity
        while (left < right) {
            // do binary search, take the middle capacity btween max and min
            int mid = (left + right) / 2, neededDays = 1, weightsPerDay = 0;
            // go through all the weights, try to see how many days are needed to ship with capacity = mid
            for (int w: weights) {
                if (weightsPerDay + w > mid) {
                    neededDays += 1;
                    weightsPerDay = 0;
                }
                weightsPerDay += w;
            }
            // if we need too many days then we need to increase the capacity
            if (neededDays > days) left = mid + 1;
            // otherwise we can try to reduce the capacity since we want to use as many days as possible within [days] to reduce the capacity as much as possible
            else right = mid;
        }
        return left;
    }
}