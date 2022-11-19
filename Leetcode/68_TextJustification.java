class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<String>();
        
        int index = 0; // index of the current word in words
        while (index < words.length) {
            // get current line where the first word is words[index]
            int count = words[index].length(); // number of chars in current line so far
            int last = index + 1; // the last word of current line (exclusive)
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                // remove extra space padded for last word
                builder.deleteCharAt(builder.length() - 1);
                // padd the remaining width with spaces
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / diff; // total spaces to pad = (maxWidth - number of of chars in line) => spaces to pad per word = total spaces/number of chars = diff
                int r = (maxWidth - count) % diff; // remainder got truncated from avg spaces per word
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    // if it's not the last word, pad spaces
                    if (i < last - 1) {
                        // for avg spaces per word, if it's the last space that may got truncated, pad one less than others
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        
        
        return lines;
    }
}