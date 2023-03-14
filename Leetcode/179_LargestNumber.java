class Solution {
    public String largestNumber(int[] nums) {
        // convert num to String[]
        String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        // sort each n1, n2 in num such that n1 comes before n2 LEQV n1 + n2 < n2 + n1
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        // return the array with all values concat as a single string except skip leading 0s
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}