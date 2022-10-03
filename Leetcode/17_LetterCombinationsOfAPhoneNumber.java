class Solution {
    public List<String> letterCombinations(String digits) {        
        ArrayList<String> combinations = new ArrayList<>();
        if(digits.length()==0) return combinations;
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(digits, 0, map, new StringBuilder(), combinations);
        return combinations;
    }
    
    public void backtrack(String digits , int idx , HashMap<Character,String> map , StringBuilder sb , List<String> ans){
        // when we went through every digit, return the string
        if(idx==digits.length()){ 
            ans.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(idx)); 
        for(int i=0;i<str.length();i++){  
            // get all the combinations that includes character i
            sb.append(str.charAt(i)); 
            backtrack(digits,idx+1,map,sb,ans);
            // now we can remove it since we already got all the combinations that includes it
            sb.deleteCharAt(sb.length()-1);
        }
    }
}