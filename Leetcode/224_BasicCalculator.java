class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        Stack<Integer>st = new Stack<>();
        // for every char
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            // for all digits in a row append it to the RHS of the current value, so its the 'ones' digit
            if(Character.isDigit(ch)){
                int val = 0;
                 while(i < s.length() && Character.isDigit(s.charAt(i))){
                     val = val * 10 + (s.charAt(i) - '0');
                     i++;
                 }
             // assume sign is positive since it's not a negative sign
             i--;
             val = val * sign;
             sign = 1;
             sum += val;   
            }
            // if cur char is left bracket, push the sum and sign to the stack
            else if(ch == '('){
              st.push(sum);
              st.push(sign);
                // reset sum and sign to be default positive
                sum = 0;
                sign = 1;
            }
            // if it's the right bracket then get the sum updated
            else if(ch == ')'){
                sum *= st.pop();
                sum += st.pop();
            }
            // if negative sign update sign
            else if(ch == '-'){
                sign*= -1;
            }
        }
        return sum;
    }
}