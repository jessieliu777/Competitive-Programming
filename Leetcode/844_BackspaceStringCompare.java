class Solution {
    public String backspaceString(String str){
        Stack<Character> result = new Stack();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '#'){
                if (!result.isEmpty()){
                    result.pop();
                }
            } else {
                result.push(str.charAt(i));
            }
        }
        return String.valueOf(result);
    }
    public boolean backspaceCompare(String s, String t) {
        return backspaceString(s).equals(backspaceString(t));
    }
}