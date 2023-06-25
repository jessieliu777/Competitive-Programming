# Write your MySQL query statement below
# Using LENGTH() is incorrect. The question is asking for the number of characters used in the content. LENGTH() returns the length of the string measured in bytes. CHAR_LENGTH() returns the length of the string measured in characters.
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15