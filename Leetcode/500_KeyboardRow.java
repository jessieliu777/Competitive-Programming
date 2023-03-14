class Solution {
    public String[] findWords(String[] words) {
        // one liner solution
        // return Stream.of(words)
        //         // convert to lower case, if it matches any of the 3 rows then keep it in the new array
        //         .filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
        //         .toArray(String[]::new);
        
        // arr of 26 which represents A-Z characters and stored the row number of the keyboard as value
        int[] rows = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> list = new ArrayList<>();
        // iterate through the given String array and take the row of first char of cur word and verified if each other character in that str points to the same row
        for(String word: words){
            String wordLower = word.toLowerCase();
            boolean isValid = true;
            int row = rows[wordLower.charAt(0)-'a'];
            for(int i=1; i<wordLower.length();i++){
               if(rows[wordLower.charAt(i)-'a']!=row){
                    isValid = false;
                    break;
                }
            }
            if(isValid) list.add(word);
        }
        return list.toArray(new String[0]);
    }
}