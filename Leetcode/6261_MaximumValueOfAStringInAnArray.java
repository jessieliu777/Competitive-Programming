class Solution {
    public int maximumValue(String[] strs) {
        int maxValue = 0;
        for (String str: strs) maxValue = str.chars().allMatch(Character::isDigit) ? Math.max(maxValue, Integer.parseInt(str)) : Math.max(maxValue, str.length());
        return maxValue;
    }
}