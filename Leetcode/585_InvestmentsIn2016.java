# Write your MySQL query statement below
SELECT ROUND(SUM(TIV_2016),2) AS TIV_2016
FROM
(SELECT *,
# the amount of people with the same value in tiv_2015
COUNT(*) OVER(PARTITION BY TIV_2015) AS CNT1,
# the amount of people with the same lat, lon
COUNT(*) OVER(PARTITION BY LAT, LON) AS CNT2
FROM INSURANCE
) AS TBL
# at least 2 people with same tiv_2015 values, and only 1 person in same lat, lon
WHERE CNT1 >= 2 AND CNT2=1