class Solution {
    public int fib(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 1; i <= n; i++){
            if (i == 1){
                res.add(1);
            } else {
                res.add(res.get(i-1) + res.get(i-2));
            }
        }
        return res.get(n);
    }
}