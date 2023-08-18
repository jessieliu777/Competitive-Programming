class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map map = new HashMap<>(); // map pattern char, word to a position
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        // use Integer instead of int
        // Integer object allows to compare with just != because there's no autoboxing-same-value-to-different-objects-problem anymore. Thanks to lap_218 for somewhat pointing that out in the comments.

        // about auto boxing:
        // You can't compare two Integer with a simple == as they're objects so most of the time references won't be the same.
        // There is a trick, with Integer between -128 and 127, references will be the same as autoboxing uses Integer.valueOf() which caches small integers.

        // int i = 10;
        // Integer a = i;
        // Integer b = i;
        // System.out.println(a == b); //guess what is the output?
        // The output was supposed to be false. However, you can test this and you will find it is true.
        // Why?

        // Because "The JVM is caching Integer values. == only works for numbers between -128 and 127 "
        // Then you can try another code:

        // int i = 1000; //greater than 127
        // Integer a = i;
        // Integer b = i;
        // System.out.println(a == b); //this time we got false
        // Look, now you get false. And now it explains why we can pass the small cases (because the indices are in the range of -128 and 127). We also know why it cannot pass the larger test case.
        for (Integer i = 0; i < words.length; i++){
            // if key already exists, put returns the old value.
            // if key did not exist, put returns null.
            // so if the pattern and the word doesn't have the same old value, that means the word was mapped to another pattern before so it's not 1-1, hence return false

            // but accessing i works since it's the same reference
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) return false;
        }
        return true;
    }
}