class Solution {
    public String decodeMessage(String key, String message) {
        StringBuilder ans = new StringBuilder();
        //Removing the spaces
        key = key.replaceAll(" ", "");
    
        HashMap<Character,Character> letters = new HashMap<>();
        //Mapping the key into a hashmap.
        char original = 'a';
        for (int i = 0; i < key.length() ; i++) {
            // map the first occurence of each letter in key to the next char in the alphabet
            if (!letters.containsKey(key.charAt(i))) letters.put(key.charAt(i),original++);
        }
        for (int i = 0; i < message.length(); i++) {
            //Now replacing the letters of the message with appropriate letter according to the key
            if (letters.containsKey(message.charAt(i))) ans.append(letters.get(message.charAt(i)));
            //This is for characters other than the letters in the key example a space " "
            else ans.append(message.charAt(i));
        }
        return ans.toString();
    }
}