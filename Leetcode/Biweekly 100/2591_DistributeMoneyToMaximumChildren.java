class Solution {
    public int distMoney(int money, int children) {
        // distribute $1 to each child
        money -= children;
        int childrenCanGet7More = money/7;
        int remainderAfterDistributing7More = money % 7;
        if (money < 0) return -1;
        // after distributing $1, try to distribute $7 more to each child
        // if each kid was able to get $7 more then every kid is able to get $8 in total
        else if (childrenCanGet7More == children && remainderAfterDistributing7More == 0) return children;
        // if exactly children-1 children can get $7 more and the last kid ends up with $3 more, then that last kid will end up with $4 in total, so give that last kid some more money from the second last kid so no one ends up with $4 => 2nd last kid no longer have $8 after giving away to last => 2 children cannot get $8 => children - 2 can get $8.
        else if (childrenCanGet7More == children - 1 && remainderAfterDistributing7More == 3) return (children - 2);
        // if money/7 more than childen-1 children (in this case can only be all children) that means all children can get $7 more, then give each kid $7 more except for the last child. Give all remaining to last child. This way every kid except last gets $8 in total => children-1 children gets $8 in total, in this case money/7 == children-1, which is handled in the last case. Note it s not possible last kid gets exactly $7 more (money & 7 == 0) as that's handled previously, and we wouldn't get here if it is.
        // now if money/7 is less than children-1 children, that means there are at least 2 children who can't receive $7 more as we don't have enough money. WLOG assume there is 2 children who can't receive $7 more. Regardless of the remainde rwe know the 2 children gets at least $1 as that's distributed in the beginning. So it doesn't matter how much more money they get since we know it won't be enough to reach $8 in total. In this case only the other children (money/7) are able to reach $8, which is covered in the last case.
        return Math.min(children - 1, childrenCanGet7More);
    }
}