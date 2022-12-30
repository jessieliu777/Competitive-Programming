class Solution {
    public String capitalizeTitle(String title) {
        String[] strArr = title.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String currentStr : strArr) {
            if (currentStr.length() > 2) {
                String firstChar = currentStr.substring(0, 1);
                String remainingChars = currentStr.substring(1, currentStr.length());
                
                firstChar = firstChar.toUpperCase();
                remainingChars = remainingChars.toLowerCase();
                
                currentStr = firstChar + remainingChars;
            } else {
                currentStr = currentStr.toLowerCase();
            }
            result.append(currentStr).append(" ");
        }
        return result.toString().trim();
    }
}