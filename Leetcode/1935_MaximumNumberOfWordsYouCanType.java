class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenKeys = new HashSet();
        for(int i=0;i<brokenLetters.length();i++)                       brokenKeys.add(brokenLetters.charAt(i));
        String[] words = text.split(" "); int count=0;
        for(String word: words){
            boolean broken = false;
            for(int i=0;i<word.length();i++){
                if(brokenKeys.contains(word.charAt(i))) {
                    broken=true;
                    break;
                }
            }
            if(!broken) count++;
        }
        return count;
    }
}