# Read from the file words.txt and output the word frequency list to stdout.
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'

# Explanation :
# tr -s ' ' '\n'
# tr -s truncates truncating each whitespace( ' ') and replace it with newline('\n') as shown below:
# ➜ ~ cat words.txt | tr -s ' ' '\n' will look like this -
# the
# day
# is
# sunny
# the
# the
# the
# sunny
# is
# is

# sort the input in ascending order so that uniq can find duplicate words adjacently (order does not matter for uniq) as shown below:
# ➜ ~ cat words.txt | tr -s ' ' '\n' | sort
# day
# is
# is
# is
# sunny
# sunny
# the
# the
# the
# the

# uniq --count
# This command provides word frequency as "count word" format.
# ➜ ~ cat words.txt | tr -s ' ' '\n' | sort | uniq --count
# 1 day
# 3 is
# 2 sunny
# 4 the
# sort -r
# sort -r sorts the input in descending order.
# ➜ ~ cat words.txt | tr -s ' ' '\n' | sort | uniq --count | sort -r
# 4 the
# 3 is
# 2 sunny
# 1 day
# awk '{print $2 " " $1}
# awk formats the input given for each line. In our example, we want the second column ($2) appears first and the first column ($1) appears second separated by whitespace(" ")

# ➜  ~ cat words.txt | tr -s ' ' '\n' | sort | uniq --count | sort -r | awk '{print $2 " " $1}'
# the 4
# is 3
# sunny 2
# day 1