# Read from the file file.txt and print its transposed content to stdout.
awk '
{
    # NF gives you the total number of fields in a record (num of cols)
    for (i = 1; i <= NF; i++) {
        # NR gives you the total number of records being processed or line number
        # if this item is the first item (row = 1), then init the new col
        if(NR == 1) {
            s[i] = $i; 
        } 
        # otherwise append to cur col
        else { 
            s[i] = s[i] " " $i;
        }
    }
}
# END part will run after it dealt with every line.
# After dealing with all the lines, the s[] array is what we want.
# END part is to print the s[], this for loop will end when s[i] is empty.
# Because the lines may have different number of words, I cannot find the length of s[] easily
END {
    # print every tranposed col (which is row now)
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt