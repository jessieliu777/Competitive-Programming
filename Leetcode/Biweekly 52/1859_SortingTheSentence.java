class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            String cur = arr[i];
            // get the last character as int
            int index = cur.charAt(cur.length()-1) - '0' - 1;
            result[index] = cur.substring(0, cur.length()-1);
        }
        return String.join(" ", result);
    }
}