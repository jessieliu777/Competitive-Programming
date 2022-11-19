class Solution {
    // function to get the result of the operation
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<Integer>();
        boolean isNumber = true;
    
        for(int i = 0; i < expression.length(); i++) {
            // check if current character is an operator
            if(!Character.isDigit(expression.charAt(i))) {
                
                // if current character is not a digit then exp is not purely a number
                isNumber = false;
                
                // list of left results
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                
                // list of right results
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // for every left, and right results we want to add left op right where op is the operator
                for(int x : left) {
                    for(int y : right) {
                        int result = 0;
                        if(expression.charAt(i) == '+') result = x + y;
                        if(expression.charAt(i) == '-') result = x - y;
                        if(expression.charAt(i) == '*') result = x * y;
                        results.add(result);
                    }
                }
                
            }
        }
        if(isNumber) results.add(Integer.valueOf(expression));
        return results;
    }
}