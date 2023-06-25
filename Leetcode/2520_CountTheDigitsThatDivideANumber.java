class Solution {
    public int countDigits(int num) {
        int answer = 0;
        int cur = num;
        // keep extracting the last digit of cur, count the number of times the extracted digit is divisible by num
        while (cur > 0){
            if(num % (cur % 10) == 0) answer++;
            cur /= 10;
        }
        return answer;
    }
}