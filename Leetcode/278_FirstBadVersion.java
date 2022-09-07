/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            // binary search
            int left = 1;
            int right = n;
            while (left <= right){
                int index = left+(right-left)/2;
                // if it's bad, move left
                if (isBadVersion(index)){
                    right = index-1;
                } else {
                    left = index+1;
                }
            }
            return left;
        }
    }