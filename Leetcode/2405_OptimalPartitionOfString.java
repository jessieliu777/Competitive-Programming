class Solution {
    public int partitionString(String s) {
        // let flag be 26 bit, each bit denoting whether the respective alphabet is visited or not
        int count = 1, len = s.length(), flag = 0;
        // go thru every char
        for (int i = 0; i < len; i++) {
            // get the int value of the char
            int val = s.charAt(i) - 'a';
            // if the val th bit is on in flag, then it's visited
            if ((flag & (1 << val)) != 0) {
                // we need to add the string into a new partition to avoid repeating, increment count as we just finished the prev partition.
                flag = 0;
                count++;
            }
            // mark cur char as visited
            flag = flag | (1 << val);
        }
        return count;
    }
}