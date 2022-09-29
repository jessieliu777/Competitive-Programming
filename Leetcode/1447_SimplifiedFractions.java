class Solution {
    int gcd(int p, int q){
        if(q == 0)
            return p;
        return gcd(q, p%q);
    }
    
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int denominator = 2; denominator <= n; denominator++){
            // 1/denominator for any denominator is already simplified
            result.add(1 + "/" + denominator);
            for (int numerator = 2; numerator < denominator; numerator++){
                if (gcd(denominator, numerator) == 1){
                    result.add(numerator + "/" + denominator);
                }
            }
        }
        return result;
    }
}