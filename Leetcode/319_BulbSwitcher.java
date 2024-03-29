class Solution {
    public int bulbSwitch(int n) {
        // A bulb ends up on iff it is switched an odd number of times.

        // Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d | i. So bulb i ends up on iff it has an odd number of divisors.

        // Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on if and only if i is a square.

        // So just count the square numbers.

        // Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n]. And 1 is the smallest root. So you have the roots from 1 to R, that's R roots. Which correspond to the R squares. So int(sqrt(n)) is the answer. SInce n may not be a square, round down for non square sqrts, which is what casting to int does anyways
        return (int) Math.sqrt(n);
    }
}