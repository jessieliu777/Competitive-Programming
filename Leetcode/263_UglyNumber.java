class Solution {
    public boolean isUgly(int n) {
        if(n==0) return false;
        // use up 2, 3, 5
        while(n%2==0||n%3==0||n%5==0){
            if(n%5==0) n/=5;
            else if(n%3==0) n/=3;
            else if(n%2==0) n/=2;
        }
        // if there's no left over after dividing by 2, 3, 5 then it's ugly, otherwise it's not
        return n==1;
    }
}