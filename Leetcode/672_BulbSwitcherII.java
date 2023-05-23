class Solution {
    public int flipLights(int n, int presses) {
        // We only need to consider special cases which n < 3 or m < 3. When n >=3 2 and m >=3, the result is 8.
        // The four buttons:
        // 1. Flip all the lights.
        // 2. Flip lights with even numbers.
        // 3. Flip lights with odd numbers.
        // 4. Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...

        // If we use button 1 and 2, it equals to use button 3.
        // Similarly...
        // 1 + 2 --> 3, 1 + 3 --> 2, 2 + 3 --> 1
        // So, there are only 8 cases.
        // All_on, 1, 2, 3, 4, 1+4, 2+4, 3+4
        // And we can get all the cases, when n >= 3 and m >= 3.

        // no presses, all lights has to be on by default status, so one status (the default)
        if (presses == 0) return 1;
        // 1 light, then its status can either be on or off regardless of the amount of presses > 0. (for press = 1, can press button 2 to do nothing)
        else if (n == 1) return 2;
        // if 2 lights and 1 press then for all buttons, it would change the status from default. 1 turns all off, 2 turns 2nd off, 3 turns 1st off, 4 turns 1st off, so total 3 statuses: all off, 2nd off, 1st off
        else if (n == 2 && presses == 1) return 3;
        // for 2 lights with > 1 press, we can easily go back to default state with second press. Ex pressing button2, then button 3. So the total status is the same as 2 lights and 1 press + default status = 3 + 1 = 4
        else if (n == 2) return 4;
        // for n > 2 and 1 press, the status have to be one of the resulting 4 buttons. 
        else if (presses == 1) return 4;
        else if (presses == 2) return 7;
        return 8;
    }
}